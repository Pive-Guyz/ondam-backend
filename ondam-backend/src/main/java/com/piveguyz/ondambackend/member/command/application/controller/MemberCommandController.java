package com.piveguyz.ondambackend.member.command.application.controller;


import com.piveguyz.ondambackend.member.command.application.dto.ChangePasswordDTO;
import com.piveguyz.ondambackend.member.command.application.dto.MemberDTO;
import com.piveguyz.ondambackend.member.command.application.dto.UpdateAuthorityDTO;
import com.piveguyz.ondambackend.member.command.application.service.MemberService;
import com.piveguyz.ondambackend.member.command.domain.vo.RequestRegistMembersVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
@Slf4j
public class MemberCommandController {
    private MemberService memberService;
    private ModelMapper modelMapper;

    @Autowired
    public MemberCommandController(MemberService memberService,
                                   ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("regist")
    public ResponseEntity<String> registMember(@RequestBody RequestRegistMembersVO newMember) {
        MemberDTO memberDTO = modelMapper.map(newMember, MemberDTO.class);
        // call by reference 는 원본을 보내고 값이 바뀌고 돌아오기 때문에 반환 x
        // userId 추가된 값
        memberService.registMember(memberDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공!");
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("회원 탈퇴 완료!");
    }
    // 비밀번호 수정
    @PutMapping("/{id}/password")
    public ResponseEntity<String> changePassword(@PathVariable Long id,
                                                 @RequestBody ChangePasswordDTO passwordDTO) {
        memberService.changePassword(id, passwordDTO);
        return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
    }


    @PostMapping("/update-authority")
    public ResponseEntity<String> updateAuthority(@RequestBody UpdateAuthorityDTO dto) {
        memberService.updateAuthority(dto);
        return ResponseEntity.ok("권한이 변경되었습니다.");
    }

    @GetMapping("/findPasswordByNameAndEmail")
    public ResponseEntity<String> findPasswordByNameAndEmail(
            @RequestParam String name,
            @RequestParam String email) {

        String tempPassword = memberService.resetPasswordWithTemp(name, email);
        if (tempPassword == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("일치하는 회원이 없습니다.");
        }
        return ResponseEntity.ok(tempPassword); // 평문 반환

    }
}
