package com.piveguyz.ondambackend.analysis;

import com.piveguyz.ondambackend.analysis.command.application.service.AnalysisService;
import com.piveguyz.ondambackend.analysis.command.domain.aggregate.Emotion;
import com.piveguyz.ondambackend.analysis.command.domain.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class AnalysisCommandTest {

    @Autowired
    AnalysisService analysisService;

    @Autowired
    AnalysisRepository analysisRepository;

    @Autowired
    TroubleSummaryRepository troubleSummaryRepository;

    @Autowired
    EmotionAnalysisRepository emotionAnalysisRepository;

    @Autowired
    EffectiveStatementRepository effectiveStatementRepository;

    @Autowired
    ShortenedCounselRepository shortenedCounselRepository;

    @Autowired
    EmotionRepository emotionRepository;

    @BeforeEach
    void setupEmotions() {
        List<String> emotionNames = List.of("불안", "우울");

        for (String name : emotionNames) {
            if (emotionRepository.findByName(name).isEmpty()) {
                emotionRepository.save(Emotion.builder().name(name).build());
            }
        }
    }

    static Stream<Arguments> saveFromDbArgs() {
        return Stream.of(Arguments.of(1L), Arguments.of(2L));
    }

    @ParameterizedTest
    @DisplayName("dbTestJson으로 분석 결과 저장 테스트")
    @MethodSource("saveFromDbArgs")
    void saveFromDbTest(Long testCounselId) {
        // when
        analysisService.testSaveAnalysis(testCounselId);

        // then
        assertTrue(analysisRepository.findByCounselId(testCounselId).isPresent());
        assertTrue(troubleSummaryRepository.findByAnalysisId(analysisRepository.findByCounselId(testCounselId).get().getId()).isPresent());

        assertFalse(emotionAnalysisRepository.findByAnalysisId(analysisRepository.findByCounselId(testCounselId).get().getId()).isEmpty());

        assertTrue(effectiveStatementRepository.findByAnalysisId(analysisRepository.findByCounselId(testCounselId).get().getId()).isPresent());

        assertTrue(shortenedCounselRepository.findByAnalysisId(analysisRepository.findByCounselId(testCounselId).get().getId()).isPresent());
    }
}