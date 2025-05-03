package com.piveguyz.ondambackend.diary;

import com.piveguyz.ondambackend.diary.query.dto.DiaryQueryDTO;
import com.piveguyz.ondambackend.diary.query.mapper.DiaryMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DiaryQueryTest {
    @Autowired
    private DiaryMapper diaryMapper;

    @Test
    @DisplayName("일기 전체 조회")
    void selectAllDiariesTest(){
        List<DiaryQueryDTO> diaryQueryDTOList = diaryMapper.findAllDiary();
        assertThat(diaryQueryDTOList).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회한 다이어리 수 : " + diaryQueryDTOList.size());
    }

    @Test
    @DisplayName("id로 일기 조회")
    void selectDiaryByIdTest(){
        DiaryQueryDTO diaryQueryDTO = diaryMapper.findDiaryById(1L);
        assertThat(diaryQueryDTO.getId()).isEqualTo(1L);
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회한 일기 id : " + diaryQueryDTO.getId());
    }

    @Test
    @DisplayName("작성자id로 일기 조회")
    void selectDiaryByMemberIdTest(){
        List<DiaryQueryDTO> diaryQueryDTOList = diaryMapper.findDiaryByMemberId(3L);
        assertThat(diaryQueryDTOList).isNotNull();
        for(DiaryQueryDTO dto : diaryQueryDTOList){
            assertThat(dto.getMemberId()).isEqualTo(3L);
        }
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회한 일기의 수 : "  + diaryQueryDTOList.size());
    }
}
