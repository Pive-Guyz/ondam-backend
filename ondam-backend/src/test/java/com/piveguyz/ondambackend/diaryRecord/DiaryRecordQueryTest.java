package com.piveguyz.ondambackend.diaryRecord;

import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import com.piveguyz.ondambackend.diaryRecord.command.application.service.DiaryRecordService;
import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import com.piveguyz.ondambackend.diaryRecord.query.service.DiaryRecordQueryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DiaryRecordQueryTest {
    @Autowired
    private DiaryRecordQueryService diaryRecordQueryService;

    @Test
    @DisplayName("일기 발송 기록 전체 조회")
    void selectAllDiaryRecordTest(){
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectAllDiaryRecord();
        assertThat(diaryRecordQueryDTOList).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회된 일기 발송 기록 수 : " + diaryRecordQueryDTOList.size());
    }

    @Test
    @DisplayName("id로 일기 발송 기록 조회")
    void selectDiaryRecordByIdTest(){
        DiaryRecordQueryDTO diaryRecordQueryDTO = diaryRecordQueryService.selectDiaryRecordById(1L);
        assertThat(diaryRecordQueryDTO.getId()).isEqualTo(1L);
        System.out.println("=== 테스트 결과 ===");
        System.out.println("일기 발송 기록 id : " + diaryRecordQueryDTO.getId());
    }

    @Test
    @DisplayName("일기id로 일기 발송 기록 조회")
    void selectDiaryRecordByDiaryIdTest(){
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByDiaryId(1L);
        assertThat(diaryRecordQueryDTOList).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회된 일기 발송 기록 수 : " + diaryRecordQueryDTOList.size());
    }

    @Test
    @DisplayName("수신자id로 일기 발송 기록 조회")
    void selectDiaryRecordByReceiverIdTest(){
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByReceiverId(3L);
        assertThat(diaryRecordQueryDTOList).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회된 일기 발송 기록 수 : " + diaryRecordQueryDTOList.size());
    }

    @Test
    @DisplayName("일기id와 수신자id로 일기 발송 기록 조회")
    void selectDiaryRecordByDiaryIdAndReceiverIdTest(){
        DiaryRecordQueryDTO diaryRecordQueryDTO = diaryRecordQueryService.selectDiaryRecordByDiaryIdAndReceiverId(3L, 4L);
        assertThat(diaryRecordQueryDTO.getDiaryId()).isEqualTo(3L);
        assertThat(diaryRecordQueryDTO.getReceiverId()).isEqualTo(4L);
        System.out.println("=== 테스트 결과 ===");
        System.out.println("일기 발송 기록의 일기 id : " + diaryRecordQueryDTO.getDiaryId());
        System.out.println("일기 발송 기록의 수신자 id : " + diaryRecordQueryDTO.getReceiverId());
    }
}
