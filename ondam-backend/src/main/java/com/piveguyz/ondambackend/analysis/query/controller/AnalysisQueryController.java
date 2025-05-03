package com.piveguyz.ondambackend.analysis.query.controller;

import com.piveguyz.ondambackend.analysis.query.dto.AnalysisResultDTO;
import com.piveguyz.ondambackend.analysis.query.service.AnalysisQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/analysis")
@Slf4j
public class AnalysisQueryController {
    private final AnalysisQueryService analysisQueryService;

    @Autowired
    public AnalysisQueryController(AnalysisQueryService analysisQueryService) {
        this.analysisQueryService = analysisQueryService;
    }

    @GetMapping("/{counselId}/analysis")
    public AnalysisResultDTO getAnalysisResult(@PathVariable Long counselId) {
        return analysisQueryService.getAnalysisResult(counselId);
    }

}
