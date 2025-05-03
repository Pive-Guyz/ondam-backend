package com.piveguyz.ondambackend.analysis.query.service;

import com.piveguyz.ondambackend.analysis.query.dto.AnalysisResultDTO;

public interface AnalysisQueryService {
    AnalysisResultDTO getAnalysisResult(Long counselId);
}
