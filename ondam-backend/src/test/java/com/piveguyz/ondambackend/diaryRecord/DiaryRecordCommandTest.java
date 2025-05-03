package com.piveguyz.ondambackend.diaryRecord;

import com.piveguyz.ondambackend.diary.command.application.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.command.application.service.DiaryService;
import com.piveguyz.ondambackend.diary.command.domain.aggregate.Diary;
import com.piveguyz.ondambackend.diary.command.domain.repository.DiaryRepository;
import com.piveguyz.ondambackend.diaryRecord.command.application.service.DiaryRecordService;
import com.piveguyz.ondambackend.diaryRecord.command.domain.aggregate.DiaryRecord;
import com.piveguyz.ondambackend.diaryRecord.command.domain.repository.DiaryRecordRepository;
import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import com.piveguyz.ondambackend.diaryRecord.query.service.DiaryRecordQueryService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DiaryRecordCommandTest {
    @Autowired
    private DiaryService diaryService;
    @Autowired
    private DiaryRecordService diaryRecordService;
    @Autowired
    private DiaryRecordQueryService diaryRecordQueryService;
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private DiaryRecordRepository diaryRecordRepository;

//    @Test
//    @DisplayName("일기 발송")
//    void sendDiaryTest(){
//        DiaryDTO diaryDTO = new DiaryDTO();
//        diaryDTO.setTitle("테스트 일기 제목");
//        diaryDTO.setContent("테스트 일기 내용");
//        diaryDTO.setMemberId(1L);
//        diaryService.writeDiary(diaryDTO);
//
//        entityManager.flush();  // DB 반영
//        entityManager.clear();  // 1차 캐시 비움
//
//        Diary diary = diaryRepository.findTopByOrderByIdDesc()
//                .orElseThrow(() -> new IllegalArgumentException("일기 없음"));
//        System.out.println("diary = " + diary);
//        Long diaryId = diary.getId();
//        System.out.println("diaryId = " + diaryId);
//        boolean result = diaryRecordService.sendDiary(diaryId);
//        System.out.println("result = " + result);
//        List<DiaryRecord> records = diaryRecordRepository.findAll();
//        System.out.println("저장된 diaryRecord 수: " + records.size()); // ✅ 여기도 확인
//
//        entityManager.flush();  // DB 반영
//        entityManager.clear();  // 1차 캐시 비움
//
//        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByDiaryId(diaryId);
//        System.out.println("diaryRecordQueryDTOList = " + diaryRecordQueryDTOList);
//        assertThat(diaryRecordQueryDTOList).isNotEmpty();
//        System.out.println("== 테스트 결과 ===");
//        System.out.println("일기 발송 횟수 : " + diaryRecordQueryDTOList.size());
//    }

    @Test
    @DisplayName("전체 발송 기록 만료")
    void expireAllDiaryRecordsTest(){
        diaryRecordService.expireAllDiaryRecords();
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectAllDiaryRecord();
        assertThat(diaryRecordQueryDTOList).isEmpty();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("만료되지 않은 발송 기록 갯수 : " + diaryRecordQueryDTOList.size());
    }
}
