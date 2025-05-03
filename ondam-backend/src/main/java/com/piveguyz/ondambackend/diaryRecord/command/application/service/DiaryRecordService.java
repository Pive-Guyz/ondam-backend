package com.piveguyz.ondambackend.diaryRecord.command.application.service;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import com.piveguyz.ondambackend.diaryRecord.command.domain.aggregate.DiaryRecord;
import com.piveguyz.ondambackend.diaryRecord.command.domain.repository.DiaryRecordRepository;
import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import com.piveguyz.ondambackend.diaryRecord.query.service.DiaryRecordQueryService;
import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import com.piveguyz.ondambackend.member.query.service.MemberQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryRecordService {
    private final DiaryQueryService diaryQueryService;
    private final DiaryRecordQueryService diaryRecordQueryService;
    private final DiaryRecordRepository diaryRecordRepository;
    private final MemberQueryService memberQueryService;

    @Autowired
    public DiaryRecordService(DiaryQueryService diaryQueryService, DiaryRecordQueryService diaryRecordQueryService, DiaryRecordRepository diaryRecordRepository, MemberQueryService memberQueryService) {
        this.diaryQueryService = diaryQueryService;
        this.diaryRecordQueryService = diaryRecordQueryService;
        this.diaryRecordRepository = diaryRecordRepository;
        this.memberQueryService = memberQueryService;
    }

    public boolean sendDiary(Long diaryId) {
        int attempt = 0;
        int Maxattempt = 100;

        List<MemberQueryDTO> allMembers = memberQueryService.selectAllMembers(); // 회원 전부 조회
        List<Long> availableMemberIds = allMembers.stream()
                .filter(member -> "N".equals(member.getIsDiaryBlocked())) // isDiaryBlocked == "N" 인 회원만
                .map(MemberQueryDTO::getId) // id만 뽑음
                .toList();

        if (availableMemberIds.isEmpty()) {
            return false; // 보낼 수 있는 사람이 없으면 중단
        }

        while (attempt <= Maxattempt) {
            attempt++;
            List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectAllDiaryRecord();
            List<DiaryQueryDTO> diaryQueryDTOList = diaryQueryService.selectAllDiaries().stream()
                    .filter(diary -> diary.getDeletedAt() == null)
                    .filter(diary -> !"Y".equals(diary.getIsBlinded()))
                    .toList();

            if (diaryRecordQueryDTOList.size() == diaryQueryDTOList.size() * 3) { // 모든 일기 다 배분 완료
                break;
            }

            diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByDiaryId(diaryId);
            if (diaryRecordQueryDTOList.size() >= 3) { // 하나의 일기를 3명한테만 보내야 함
                break;
            }

            int randomIndex = (int) (Math.random() * availableMemberIds.size());
            Long receiverId = availableMemberIds.get(randomIndex);

            diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByReceiverId(receiverId);
            if (diaryRecordQueryDTOList.size() >= 3) { // 일기를 3개 받은 사람은 안 됨
                continue;
            }

            DiaryQueryDTO diaryQueryDTO = diaryQueryService.selectDiaryById(diaryId);
            Long senderId = diaryQueryDTO.getMemberId();

            if (senderId == receiverId) { // 본인한테는 보내지 않음
                continue;
            }

            DiaryRecordQueryDTO diaryRecordQueryDTO = diaryRecordQueryService.selectDiaryRecordByDiaryIdAndReceiverId(diaryId, receiverId);
            if (diaryRecordQueryDTO != null) { // 이미 받은 사람이면 패스
                continue;
            }

            DiaryRecord diaryRecord = new DiaryRecord();
            diaryRecord.setDiaryId(diaryId);
            diaryRecord.setSenderId(senderId);
            diaryRecord.setReceiverId(receiverId);
            diaryRecord.setIsExpired("N");
            try {
                diaryRecordRepository.save(diaryRecord);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public int expireAllDiaryRecords() {
        return diaryRecordRepository.expireAllDiaryRecords();
    }
}
