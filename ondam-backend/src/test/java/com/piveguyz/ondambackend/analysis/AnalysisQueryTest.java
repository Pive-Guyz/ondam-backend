package com.piveguyz.ondambackend.analysis;

import com.piveguyz.ondambackend.analysis.command.application.service.AnalysisService;
import com.piveguyz.ondambackend.analysis.query.dto.*;
import com.piveguyz.ondambackend.analysis.query.service.AnalysisQueryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AnalysisQueryTest {

    @Autowired
    AnalysisService analysisService;

    @Autowired
    AnalysisQueryService analysisQueryService;

    // 조회할 데이터 미리 넣어두기
    @BeforeEach
    void setUp() {
        analysisService.testSaveAnalysis(1L);
        analysisService.testSaveAnalysis(2L);
    }

    static Stream<Arguments> getAnalysisResultArgs() {
        return Stream.of(
                Arguments.of(1L),
                Arguments.of(2L)
        );
    }

    @ParameterizedTest
    @DisplayName("분석 결과 조회")
    @MethodSource("getAnalysisResultArgs")
    void getAnalysisResultTest(Long counselId) {
        AnalysisResultDTO result = analysisQueryService.getAnalysisResult(counselId);

        // then
        assertNotNull(result);
        assertNotNull(result.getTroubleSummary());
        assertNotNull(result.getEffectiveStatement());
        assertNotNull(result.getShortenedCounsel());
        assertNotNull(result.getEmotionAnalysisList());
        assertFalse(result.getEmotionAnalysisList().isEmpty());

        // 출력
        System.out.println("분석 ID: " + result.getId());
        System.out.println("🧠 고민 요약:");
        System.out.println("- 시기: " + result.getTroubleSummary().getPeriod());
        System.out.println("- 장소: " + result.getTroubleSummary().getPlace());
        System.out.println("- 상황: " + result.getTroubleSummary().getSituation());
        System.out.println("- 이유: " + result.getTroubleSummary().getReason());
        System.out.println("- 흐름: " + result.getTroubleSummary().getFlow());
        System.out.println("- 결심: " + result.getTroubleSummary().getDetermination());

        System.out.println("\n🎯 효과적 발화:");
        System.out.println("- 내용: " + result.getEffectiveStatement().getContent());
        System.out.println("- 반응: " + result.getEffectiveStatement().getResponse());
        System.out.println("- 이유: " + result.getEffectiveStatement().getReason());
        System.out.println("- 결과: " + result.getEffectiveStatement().getResult());

        System.out.println("\n📄 상담 요약:");
        System.out.println("- 정서 변화: " + result.getShortenedCounsel().getEmotionalChange());
        System.out.println("- 인지: " + result.getShortenedCounsel().getCognitive());
        System.out.println("- 행동: " + result.getShortenedCounsel().getBehavioral());
        System.out.println("- 반응: " + result.getShortenedCounsel().getResponse());
        System.out.println("- 추천: " + result.getShortenedCounsel().getRecommendedDirection());

        System.out.println("\n💬 감정 분석 목록:");
        for (EmotionAnalysisDTO ea : result.getEmotionAnalysisList()) {
            System.out.println("- 감정: " + ea.getEmotion());
            System.out.println("  근거: " + ea.getEvidence());
            System.out.println("  이유: " + ea.getReason());
        }
    }
}
