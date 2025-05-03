package com.piveguyz.ondambackend.analysis;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.Emotion;
import com.piveguyz.ondambackend.analysis.command.domain.repository.EmotionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class EmotionCommandTest {
    @Autowired
    private EmotionRepository emotionRepository;

    // 수정, 삭제를 위해 미리 넣어두기
    @BeforeEach
    void setup() {
        emotionRepository.save(Emotion.builder()
                .name("기쁨 테스트")
                .emotionCategoryId(1L)
                .build());
        emotionRepository.save(Emotion.builder()
                .name("안도 테스트")
                .emotionCategoryId(1L)
                .build());
    }

    // 감정 등록 테스트
    static Stream<Arguments> createEmotionArgs() {
        return Stream.of(
                Arguments.of("우울 테스트", 2L),
                Arguments.of("슬픔 테스트", 2L)
        );
    }

    @ParameterizedTest
    @DisplayName("감정 등록 테스트")
    @MethodSource("createEmotionArgs")
    void createEmotionTest(String name, Long emotionCategoryId) {
        if (emotionRepository.existsByName(name)) {
            throw new IllegalArgumentException("이미 존재하는 감정입니다: " + name);
        }

        Emotion newEmotion = Emotion.builder()
                .name(name)
                .emotionCategoryId(emotionCategoryId)
                .build();

        emotionRepository.save(newEmotion);
        assertTrue(emotionRepository.existsByName(name));
    }


    // 감정 수정 테스트
    static Stream<Arguments> updateEmotionArgs() {
        return Stream.of(
                Arguments.of("기쁨 테스트", "대인관계 테스트"),
                Arguments.of("안도 테스트", "즐거움 테스트")
        );
    }

    @ParameterizedTest
    @DisplayName("감정 수정 테스트")
    @MethodSource("updateEmotionArgs")
    void updateEmotionTest(String oldName, String newName) {
        Emotion existingEmotion = emotionRepository.findByName(oldName).
                orElseThrow(() -> new IllegalArgumentException("기존 감정 정보를 찾을 수 없습니다: " + oldName));

        // 감정 이름 수정
        existingEmotion.update(newName, existingEmotion.getEmotionCategoryId());
        emotionRepository.save(existingEmotion);

        assertTrue(emotionRepository.existsByName(newName));
    }

    // 감정 삭제 테스트
    static Stream<Arguments> deleteEmotionArgs() {
        return Stream.of(Arguments.of("기쁨 테스트"), Arguments.of("안도 테스트"));
    }

    @ParameterizedTest
    @DisplayName("감정 삭제 테스트")
    @MethodSource("deleteEmotionArgs")
    void deleteEmotionTest(String name) {
        Emotion existingEmotion = emotionRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 감정 정보를 찾을 수 없습니다: " + name));

        emotionRepository.delete(existingEmotion);

        assertFalse(emotionRepository.existsByName(name), "감정 정보가 정상적으로 삭제되지 않았습니다.");
    }
}
