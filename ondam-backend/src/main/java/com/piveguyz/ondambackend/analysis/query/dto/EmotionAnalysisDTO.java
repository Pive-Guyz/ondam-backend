package com.piveguyz.ondambackend.analysis.query.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class EmotionAnalysisDTO {
    private Long id;
    private String emotion;
    private String evidence;
    private String reason;
    private String emotionCategoryName;

    @Builder
    public EmotionAnalysisDTO(Long id,
                              String emotion,
                              String evidence,
                              String reason,
                              String emotionCategoryName) {
        this.id = id;
        this.emotion = emotion;
        this.evidence = evidence;
        this.reason = reason;
        this.emotionCategoryName = emotionCategoryName;
    }
}
