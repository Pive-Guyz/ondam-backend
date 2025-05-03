package com.piveguyz.ondambackend.diary.command.application.service;


import com.piveguyz.ondambackend.diary.command.application.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.command.domain.aggregate.Diary;
import com.piveguyz.ondambackend.diary.command.domain.repository.DiaryRepository;
import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.mapper.DiaryMapper;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import com.piveguyz.ondambackend.member.command.application.service.MemberService;
import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import com.piveguyz.ondambackend.member.query.service.MemberQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final DiaryMapper diaryMapper;
    private final DiaryQueryService diaryQueryService;
    private final MemberQueryService memberQueryService;  // query Service
    private final MemberService memberService;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository, DiaryMapper diaryMapper, DiaryQueryService diaryQueryService, MemberQueryService memberQueryService, MemberService memberService) {
        this.diaryRepository = diaryRepository;
        this.diaryMapper = diaryMapper;
        this.diaryQueryService = diaryQueryService;
        this.memberQueryService = memberQueryService;
        this.memberService = memberService;
    }

    public boolean writeDiary(DiaryDTO diaryDTO) {
        Long writerId = diaryDTO.getMemberId();
        MemberQueryDTO memberQueryDTO = memberQueryService.findMemberById(writerId);
        Integer point = memberQueryDTO.getPoint();
        if(point < 10){
            return false;   // point 10미만은 일기 작성 불가
        }
        Diary diary = new Diary();
        diary.setTitle(diaryDTO.getTitle());
        diary.setContent(diaryDTO.getContent());
        diary.setCreatedAt(diaryDTO.getCreatedAt() != null ? diaryDTO.getCreatedAt() : LocalDateTime.now());
        diary.setDeletedAt(diaryDTO.getDeletedAt());
        diary.setIsBlinded(diaryDTO.getIsBlinded() != null ? diaryDTO.getIsBlinded() : "N");
        diary.setMemberId(diaryDTO.getMemberId());

        try {
            diaryRepository.save(diary);
            memberService.minusPoint(writerId);     // 10점 차감
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteDiary(Long id) {
        DiaryQueryDTO diaryQueryDTO = diaryQueryService.selectDiaryById(id);
        Diary diary = new Diary();
        diary.setId(diaryQueryDTO.getId());
        diary.setTitle(diaryQueryDTO.getTitle());
        diary.setContent(diaryQueryDTO.getContent());
        diary.setCreatedAt(diaryQueryDTO.getCreatedAt());
        diary.setDeletedAt(LocalDateTime.now());
        diary.setIsBlinded(diaryQueryDTO.getIsBlinded());
        diary.setMemberId(diaryQueryDTO.getMemberId());

        try {
            diaryRepository.save(diary);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean blindDiary(Long id){
        DiaryQueryDTO diaryQueryDTO = diaryQueryService.selectDiaryById(id);
        Diary diary = new Diary();
        diary.setId(diaryQueryDTO.getId());
        diary.setTitle(diaryQueryDTO.getTitle());
        diary.setContent(diaryQueryDTO.getContent());
        diary.setCreatedAt(diaryQueryDTO.getCreatedAt());
        diary.setDeletedAt(diaryQueryDTO.getDeletedAt());
        diary.setIsBlinded("Y");
        diary.setMemberId(diaryQueryDTO.getMemberId());

        try {
            diaryRepository.save(diary);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
