package com.piveguyz.ondambackend.reply;

import com.piveguyz.ondambackend.reply.command.application.dto.ReplyDTO;
import com.piveguyz.ondambackend.reply.command.application.service.ReplyService;
import com.piveguyz.ondambackend.reply.command.domain.aggregate.Reply;
import com.piveguyz.ondambackend.reply.command.domain.repository.ReplyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ReplyCommandTest {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    @DisplayName("답장 작성")
    void writeReplyTest(){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setTitle("테스트 답장 제목");
        replyDTO.setContent("테스트 답장 내용");
        replyDTO.setDiaryRecordId(1L);
        replyService.writeReply(replyDTO);
        Reply reply = replyRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("답장 없음"));

        assertThat(reply.getTitle()).isEqualTo("테스트 답장 제목");
        assertThat(reply.getContent()).isEqualTo("테스트 답장 내용");
        System.out.println("=== 테스트 결과 ===");
        System.out.println("답장 제목 : " + reply.getTitle());
        System.out.println("답장 내용 : " + reply.getContent());
    }

    @Test
    @DisplayName("답장 삭제")
    void deleteDiaryTest() {
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setTitle("테스트 답장 제목");
        replyDTO.setContent("테스트 답장 내용");
        replyDTO.setDiaryRecordId(1L);
        replyService.writeReply(replyDTO);
        Reply reply = replyRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("답장 없음"));
        Long replyId = reply.getId();
        replyService.deleteReply(replyId);

        reply = replyRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("답장 없음"));

        assertThat(reply.getDeletedAt()).isNotNull();
        System.out.println("=== 테스트 결과 ===");
        System.out.println("답장 삭제 일시: " + reply.getDeletedAt());
    }

    @Test
    @DisplayName("답장 블라인드")
    void blindDiaryTest() {
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setTitle("테스트 답장 제목");
        replyDTO.setContent("테스트 답장 내용");
        replyDTO.setDiaryRecordId(1L);
        replyService.writeReply(replyDTO);
        Reply reply = replyRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("답장 없음"));

        Long replyId = reply.getId();
        replyService.blindReply(replyId);

        reply = replyRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("답장 없음"));

        assertThat(reply.getIsBlinded()).isEqualTo("Y");
        System.out.println("=== 테스트 결과 ===");
        System.out.println("답장 블라인드 여부: " + reply.getIsBlinded());
    }
}
