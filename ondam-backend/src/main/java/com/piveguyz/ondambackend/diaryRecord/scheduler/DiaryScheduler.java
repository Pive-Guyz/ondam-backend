package com.piveguyz.ondambackend.diaryRecord.scheduler;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.service.DiaryQueryService;
import com.piveguyz.ondambackend.diaryRecord.command.application.service.DiaryRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;


import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class DiaryScheduler {
    private final RestTemplate restTemplate = new RestTemplate(); // API 호출용
    private final DiaryQueryService diaryQueryService;
    private final DiaryRecordService diaryRecordService;


    // 매일 새벽 12시 (cron: 초 분 시 일 월 요일)
    @Scheduled(cron = "0 0 0 * * *")
    public void sendYesterdayDiaries() {
        // 💥 기존 일기 전송 기록 모두 만료 처리
        int expiredCount = diaryRecordService.expireAllDiaryRecords();
        System.out.println("만료 처리된 일기 레코드 수: " + expiredCount);

        // 1. 어제 일기 전송
        List<DiaryQueryDTO> diaryQueryDTOList = diaryQueryService.selectAllDiaries();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        for (DiaryQueryDTO diaryQueryDTO : diaryQueryDTOList) {
            if (diaryQueryDTO.getCreatedAt().toLocalDate().isEqual(yesterday)) {
                diaryRecordService.sendDiary(diaryQueryDTO.getId());
            }
        }
    }
}
