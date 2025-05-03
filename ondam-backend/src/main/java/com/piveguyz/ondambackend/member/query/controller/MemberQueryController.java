package com.piveguyz.ondambackend.member.query.controller;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import com.piveguyz.ondambackend.member.query.service.MemberQueryService;
import com.piveguyz.ondambackend.member.query.vo.RequestLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberQueryController {
    private MemberQueryService memberService;

    @Autowired
    public MemberQueryController(MemberQueryService memberQueryService) {
        this.memberService = memberQueryService;
    }

    @GetMapping("/findAllMembers")
    public List<MemberQueryDTO> findAllMembers() {
        List<MemberQueryDTO> memberDTOList = memberService.selectAllMembers();
        return memberDTOList;
    }

    @PostMapping("login")
    public ResponseEntity<?> loginMember(@RequestBody RequestLoginVO requestLoginVO) {
        MemberQueryDTO loginResult = memberService.loginMember(
                requestLoginVO.getEmail(),
                requestLoginVO.getPassword()
        );
        if (loginResult != null) {
            return ResponseEntity.ok(loginResult);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }

    @GetMapping("/findMemberById") // ★ 추가
    public ResponseEntity<MemberQueryDTO> findMemberById(@RequestParam("id") Long id) {
        MemberQueryDTO memberDTO = memberService.findMemberById(id);
        if (memberDTO != null) {
            return ResponseEntity.ok(memberDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/find-id")
    public ResponseEntity<?> findId(@RequestParam("name") String name, @RequestParam("phone") String phone) {
        MemberQueryDTO memberDTO = memberService.findMemberByNameAndPhone(name, phone);
        if (memberDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("회원 정보가 일치하지 않습니다.");
        }
        return ResponseEntity.ok("아이디 찾기 완료! \n 이메일: " + memberDTO.getEmail());
    }
//
//    @GetMapping("/find-password")
//    public ResponseEntity<?> findPassword(@RequestParam("name") String name, @RequestParam("email") String email) {
//        MemberQueryDTO memberDTO = memberService.findMemberByNameAndEmail(name, email);
//        if (memberDTO == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("회원 정보가 일치하지 않습니다.");
//        }
//        return ResponseEntity.ok("비밀번호 찾기 완료!");
//    }
}

