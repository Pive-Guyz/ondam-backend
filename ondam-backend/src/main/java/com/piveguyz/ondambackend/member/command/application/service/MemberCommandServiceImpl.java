package com.piveguyz.ondambackend.member.command.application.service;

import com.piveguyz.ondambackend.member.command.application.dto.ChangePasswordDTO;
import com.piveguyz.ondambackend.member.command.application.dto.MemberDTO;
import com.piveguyz.ondambackend.member.command.application.dto.UpdateAuthorityDTO;
import com.piveguyz.ondambackend.member.command.domain.aggregate.MemberEntity;
import com.piveguyz.ondambackend.member.command.domain.repository.MemberRepository;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import com.piveguyz.ondambackend.member.query.service.MemberQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class MemberCommandServiceImpl implements MemberService {

    private final MemberQueryService memberQueryService;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;



    public MemberCommandServiceImpl(MemberRepository memberRepository,
                                    ModelMapper modelMapper,
                                    MemberQueryService memberQueryService) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.memberQueryService = memberQueryService;
    }

    // 회원가입
    @Override
    @Transactional
    public void registMember(MemberDTO memberDTO) {

        MemberEntity registMember = modelMapper.map(memberDTO, MemberEntity.class);

        System.out.println(registMember);
        registMember.setPoint(30);
        registMember.setAuthority("GUEST");
        registMember.setIsBanned("N");
        registMember.setIsDiaryBlocked("N");

        memberRepository.save(registMember);
    }

    //회원탈퇴
    @Override
    @Transactional
    public void deleteMember(Long id) {
        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));

        if (member.getDeletedAt() != null) {
            throw new RuntimeException("이미 탈퇴한 회원입니다.");
        }

        member.setDeletedAt(LocalDateTime.now()); // java.util.Date 현재시간
        memberRepository.save(member);
    }
        // 비밀번호 수정
    @Override
    @Transactional
    public void changePassword(Long id, ChangePasswordDTO passwordDTO) {
        MemberEntity member = memberRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));

        if (!member.getPassword().equals(passwordDTO.getCurrentPassword())) {
            throw new RuntimeException("현재 비밀번호가 일치하지 않습니다.");
        }

        if (!passwordDTO.getNewPassword().equals(passwordDTO.getNewPasswordCheck())) {
            throw new RuntimeException("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        member.setPassword(passwordDTO.getNewPassword());
        memberRepository.save(member);
    }


    @Override
    public void updateAuthority(UpdateAuthorityDTO dto) {
        MemberEntity member = memberRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        member.setAuthority(dto.getAuthority());
        memberRepository.save(member);
    }



    // add point
    public void plusPoint(Long id) {
        MemberQueryDTO memberQueryDTO = memberQueryService.findMemberById(id);
        Integer point = memberQueryDTO.getPoint();
        point += 10;
        memberQueryDTO.setPoint(point);
        MemberEntity member = new MemberEntity();
        member.setId(memberQueryDTO.getId());
        member.setName(memberQueryDTO.getName());
        member.setEmail(memberQueryDTO.getEmail());
        member.setPassword(memberQueryDTO.getPassword());
        member.setBirthday(memberQueryDTO.getBirthday());
        LocalDateTime createdAt = memberQueryDTO.getCreatedAt();
        if (createdAt == null) {
            createdAt = LocalDateTime.now(); // 기본값
        }
        member.setCreatedAt(createdAt);
        member.setDeletedAt(memberQueryDTO.getDeletedAt());
        member.setPhone(memberQueryDTO.getPhone());
        member.setProfileImageUrl(memberQueryDTO.getProfileImageUrl());
        member.setAddress(memberQueryDTO.getAddress());
        member.setPoint(memberQueryDTO.getPoint());
        member.setAuthority(memberQueryDTO.getAuthority());
        member.setIsBanned(memberQueryDTO.getIsBanned());
        member.setIsDiaryBlocked(memberQueryDTO.getIsDiaryBlocked());
        memberRepository.save(member);
    }


    // minus point
    public void minusPoint(Long id) {
        MemberQueryDTO memberQueryDTO = memberQueryService.findMemberById(id);
        Integer point = memberQueryDTO.getPoint();
        point -= 10;
        memberQueryDTO.setPoint(point);
        MemberEntity member = new MemberEntity();
        member.setId(memberQueryDTO.getId());
        member.setName(memberQueryDTO.getName());
        member.setEmail(memberQueryDTO.getEmail());
        member.setPassword(memberQueryDTO.getPassword());
        member.setBirthday(memberQueryDTO.getBirthday());
        member.setCreatedAt(memberQueryDTO.getCreatedAt());
        member.setDeletedAt(memberQueryDTO.getDeletedAt());
        member.setPhone(memberQueryDTO.getPhone());
        member.setProfileImageUrl(memberQueryDTO.getProfileImageUrl());
        member.setAddress(memberQueryDTO.getAddress());
        member.setPoint(memberQueryDTO.getPoint());
        member.setAuthority(memberQueryDTO.getAuthority());
        member.setIsBanned(memberQueryDTO.getIsBanned());
        member.setIsDiaryBlocked(memberQueryDTO.getIsDiaryBlocked());
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public String resetPasswordWithTemp(String name, String email) {
        MemberQueryDTO member = memberQueryService.findMemberByNameAndEmail(name, email);
        if (member == null) return null;

        // 랜덤 임시 비밀번호 생성
        String tempPassword = generateTempPassword();

        // DB에서 실제 엔티티 가져와서 비번 업데이트
        MemberEntity entity = memberRepository.findByIdAndDeletedAtIsNull(member.getId())
                .orElseThrow(() -> new RuntimeException("회원이 존재하지 않거나 탈퇴됨"));

        entity.setPassword(tempPassword); // 평문 저장
        memberRepository.save(entity);    // 저장

        return tempPassword;
    }

    private String generateTempPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

}





