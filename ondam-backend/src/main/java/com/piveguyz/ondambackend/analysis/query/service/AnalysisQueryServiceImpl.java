package com.piveguyz.ondambackend.analysis.query.service;

import com.piveguyz.ondambackend.analysis.query.dto.AnalysisResultDTO;
import com.piveguyz.ondambackend.analysis.query.dto.EmotionAnalysisDTO;
import com.piveguyz.ondambackend.analysis.query.mapper.AnalysisResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisQueryServiceImpl implements AnalysisQueryService {
    private final AnalysisResultMapper analysisResultMapper;

    @Autowired
    public AnalysisQueryServiceImpl(AnalysisResultMapper analysisResultMapper) {
        this.analysisResultMapper = analysisResultMapper;
    }

    @Override
    public AnalysisResultDTO getAnalysisResult(Long counselId) {
        AnalysisResultDTO result = analysisResultMapper.selectAnalysisResult(counselId);
        List<EmotionAnalysisDTO> emotionList = analysisResultMapper.selectEmotionAnalysisList(result.getId());

        return AnalysisResultDTO.builder()
                .id(result.getId())
                .troubleSummary(result.getTroubleSummary())
                .effectiveStatement(result.getEffectiveStatement())
                .shortenedCounsel(result.getShortenedCounsel())
                .emotionAnalysisList(emotionList)
                .build();
    }

}
