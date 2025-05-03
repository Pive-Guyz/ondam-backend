package com.piveguyz.ondambackend.diary;

import com.piveguyz.ondambackend.diary.command.application.dto.DiaryDTO;
import com.piveguyz.ondambackend.diary.command.application.service.DiaryService;
import com.piveguyz.ondambackend.diary.command.domain.aggregate.Diary;
import com.piveguyz.ondambackend.diary.command.domain.repository.DiaryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DiaryCommandTest {
    @Autowired
    private DiaryService diaryService;
    @Autowired
    private DiaryRepository diaryRepository;

    @Test
    @DisplayName("일기 작성")
    void writeDiaryTest() {
        DiaryDTO diaryDTO = new DiaryDTO();
        diaryDTO.setTitle("테스트 일기 제목");
        diaryDTO.setContent("테스트 일기 내용");
        diaryDTO.setMemberId(1L);
        diaryService.writeDiary(diaryDTO);

        Diary diary = diaryRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("일기 없음"));

        assertThat(diary.getTitle()).isEqualTo("테스트 일기 제목");
        assertThat(diary.getContent()).isEqualTo("테스트 일기 내용");
        System.out.println("=== 테스트 결과 ===");
        System.out.println("일기 제목 : " +  diary.getTitle());
        System.out.println("일기 내용 : " + diary.getContent());
    }

    @Test
    @DisplayName("일기 삭제")
    void deleteDiaryTest() {
        DiaryDTO diaryDTO = new DiaryDTO();
        diaryDTO.setTitle("테스트 일기 제목");
        diaryDTO.setContent("테스트 일기 내용");
        diaryDTO.setMemberId(1L);
        diaryService.writeDiary(diaryDTO);

        Diary diary = diaryRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("일기 없음"));
        Long diaryId = diary.getId();
        diaryService.deleteDiary(diaryId);

        diary = diaryRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("일기 없음"));

        assertThat(diary.getDeletedAt()).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("일기 삭제 일시: " + diary.getDeletedAt());
    }

    @Test
    @DisplayName("일기 블라인드")
    void blindDiaryTest() {
        DiaryDTO diaryDTO = new DiaryDTO();
        diaryDTO.setTitle("테스트 일기 제목");
        diaryDTO.setContent("테스트 일기 내용");
        diaryDTO.setMemberId(1L);
        diaryService.writeDiary(diaryDTO);

        Diary diary = diaryRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("일기 없음"));
        Long diaryId = diary.getId();
        diaryService.blindDiary(diaryId);

        diary = diaryRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("일기 없음"));

        assertThat(diary.getIsBlinded()).isEqualTo("Y");
        System.out.println("=== 테스트 결과 ===");
        System.out.println("일기 블라인드 여부: " + diary.getIsBlinded());
    }
}
