package com.piveguyz.ondambackend.analysis.command.domain.repository;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.EmotionAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmotionAnalysisRepository extends JpaRepository<EmotionAnalysis, Long> {
    void deleteByAnalysisId(Long analysisId);

    long countByEmotionId(Long id);

    List<EmotionAnalysis> findByAnalysisId(Long analysisId);
}
