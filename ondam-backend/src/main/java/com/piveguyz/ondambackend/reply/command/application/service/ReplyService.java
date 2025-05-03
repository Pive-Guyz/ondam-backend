package com.piveguyz.ondambackend.reply.command.application.service;



import com.piveguyz.ondambackend.diaryRecord.query.dto.DiaryRecordQueryDTO;
import com.piveguyz.ondambackend.diaryRecord.query.service.DiaryRecordQueryService;
import com.piveguyz.ondambackend.member.command.application.service.MemberService;
import com.piveguyz.ondambackend.reply.command.application.dto.ReplyDTO;
import com.piveguyz.ondambackend.reply.command.domain.aggregate.Reply;
import com.piveguyz.ondambackend.reply.command.domain.repository.ReplyRepository;
import com.piveguyz.ondambackend.reply.query.dto.ReplyQueryDTO;
import com.piveguyz.ondambackend.reply.query.service.ReplyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyQueryService replyQueryService;
    private final DiaryRecordQueryService diaryRecordQueryService;
    private final MemberService memberService;

    @Autowired
    public ReplyService(ReplyRepository replyRepository, ReplyQueryService replyQueryService, DiaryRecordQueryService diaryRecordQueryService, MemberService memberService) {
        this.replyRepository = replyRepository;
        this.replyQueryService = replyQueryService;
        this.diaryRecordQueryService = diaryRecordQueryService;
        this.memberService = memberService;
    }

    public boolean writeReply(ReplyDTO replyDTO) {
        Long diaryRecordId = replyDTO.getDiaryRecordId();
        DiaryRecordQueryDTO diaryRecordQueryDTO = diaryRecordQueryService.selectDiaryRecordById(diaryRecordId);
        Long senderId = diaryRecordQueryDTO.getReceiverId();
        Long receiverId = diaryRecordQueryDTO.getSenderId();

        Reply reply = new Reply();
        reply.setTitle(replyDTO.getTitle());
        reply.setContent(replyDTO.getContent());
        reply.setCreatedAt(LocalDateTime.now());
        reply.setDeletedAt(null);
        reply.setIsBlinded("N");
        reply.setDiaryRecordId(diaryRecordId);
        reply.setSenderId(senderId);
        reply.setReceiverId(receiverId);

        try {
            replyRepository.save(reply);
            memberService.plusPoint(senderId);      // 10점 추가
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteReply(Long replyId) {
        ReplyQueryDTO replyQueryDTO = replyQueryService.selectReplyById(replyId);
        Reply reply = new Reply();
        reply.setId(replyQueryDTO.getId());
        reply.setTitle(replyQueryDTO.getTitle());
        reply.setContent(replyQueryDTO.getContent());
        reply.setCreatedAt(replyQueryDTO.getCreatedAt());
        reply.setDeletedAt(LocalDateTime.now());
        reply.setIsBlinded(replyQueryDTO.getIsBlinded());
        reply.setDiaryRecordId(replyQueryDTO.getDiaryRecordId());
        reply.setSenderId(replyQueryDTO.getSenderId());
        reply.setReceiverId(replyQueryDTO.getReceiverId());

        try {
            replyRepository.save(reply);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean blindReply(Long replyId){
        ReplyQueryDTO replyQueryDTO = replyQueryService.selectReplyById(replyId);
        Reply reply = new Reply();
        reply.setId(replyQueryDTO.getId());
        reply.setTitle(replyQueryDTO.getTitle());
        reply.setContent(replyQueryDTO.getContent());
        reply.setCreatedAt(replyQueryDTO.getCreatedAt());
        reply.setDeletedAt(replyQueryDTO.getDeletedAt());
        reply.setIsBlinded("Y");
        reply.setDiaryRecordId(replyQueryDTO.getDiaryRecordId());
        reply.setSenderId(replyQueryDTO.getSenderId());
        reply.setReceiverId(replyQueryDTO.getReceiverId());

        try {
            replyRepository.save(reply);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
