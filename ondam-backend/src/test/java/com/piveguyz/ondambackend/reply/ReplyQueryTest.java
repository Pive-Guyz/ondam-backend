package com.piveguyz.ondambackend.reply;

import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;
import com.piveguyz.ondambackend.reply.query.service.ReplyQueryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ReplyQueryTest {
    @Autowired
    private ReplyQueryService replyQueryService;

    @Test
    @DisplayName("모든 답장 조회")
    void selectAllReplyTest(){
        List<ReplyQueryDTO> replyQueryDTOList = replyQueryService.selectAllReply();
        assertThat(replyQueryDTOList).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회한 답장 수 : " + replyQueryDTOList.size());
    }

    @Test
    @DisplayName("id로 답장 조회")
    void selectReplyByIdTest(){
        ReplyQueryDTO replyQueryDTO = replyQueryService.selectReplyById(1L);
        assertThat(replyQueryDTO.getId()).isEqualTo(1L);
        System.out.println("=== 테스트 결과 ===");
        System.out.println("답장의 id : " + replyQueryDTO.getId());
    }

    @Test
    @DisplayName("일기id로 답장 조회")
    void selectReplyByDiaryIdTest(){
        List<ReplyQueryDTO> replyQueryDTOList = replyQueryService.selectReplyByDiaryId(1L);
        assertThat(replyQueryDTOList).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회한 답장 수 : " + replyQueryDTOList.size());
    }

    @Test
    @DisplayName("발신자id로 답장 조회")
    void selectReplyBySenderIdTest(){
        List<ReplyQueryDTO> replyQueryDTOList = replyQueryService.selectReplyBySenderId(4L);
        System.out.println("=== 테스트 결과 ===");
        System.out.println("조회한 답장 수 : " + replyQueryDTOList.size());
    }
}
