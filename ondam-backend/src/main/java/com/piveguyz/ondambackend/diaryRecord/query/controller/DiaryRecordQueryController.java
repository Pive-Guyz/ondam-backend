package com.piveguyz.ondambackend.diaryRecord.query.controller;

import com.piveguyz.ondambackend.diary.command.domain.aggregate.Diary;
import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import com.piveguyz.ondambackend.diaryRecord.query.service.DiaryRecordQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diaryRecord")
public class DiaryRecordQueryController {
    private DiaryRecordQueryService diaryRecordQueryService;

    @Autowired
    public DiaryRecordQueryController(DiaryRecordQueryService diaryRecordQueryService) {
        this.diaryRecordQueryService = diaryRecordQueryService;
    }

    @GetMapping("/findAllDiaryRecord")
    public List<DiaryRecordQueryDTO> findAllDiaryRecord() {
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectAllDiaryRecord();
        return diaryRecordQueryDTOList;
    }

    @GetMapping("findDiaryRecordById")
    public DiaryRecordQueryDTO findDiaryRecordById(@RequestParam("id") Long id) {
        DiaryRecordQueryDTO diaryRecordQueryDTO = diaryRecordQueryService.selectDiaryRecordById(id);
        return diaryRecordQueryDTO;
    }

    @GetMapping("/findDiaryRecordByDiaryId")
    public List<DiaryRecordQueryDTO> findDiaryRecordByDiaryId(@RequestParam("diaryId") Long diaryId) {
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList = diaryRecordQueryService.selectDiaryRecordByDiaryId(diaryId);
        return diaryRecordQueryDTOList;
    }

    @GetMapping("/findDiaryRecordByReceiverId")
    public List<DiaryRecordQueryDTO> findDiaryRecordByReceiverId(@RequestParam("receiverId") Long receiverId) {
        List<DiaryRecordQueryDTO> diaryRecordQueryDTOList
                = diaryRecordQueryService.selectDiaryRecordByReceiverId(receiverId);
        return diaryRecordQueryDTOList;
    }

    @GetMapping("/findDiaryRecordByDiaryIdAndReceiverId")
    public DiaryRecordQueryDTO findDiaryRecordByDiaryIdAndReceiverId(@RequestParam("diaryId") Long diaryId,
                                                                           @RequestParam("receiverId") Long receiverId) {
        DiaryRecordQueryDTO diaryRecordQueryDTO
                = diaryRecordQueryService.selectDiaryRecordByDiaryIdAndReceiverId(diaryId, receiverId);
        return diaryRecordQueryDTO;
    }
}
