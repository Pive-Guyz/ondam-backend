package com.piveguyz.ondambackend.member.command.application.service;

import com.piveguyz.ondambackend.member.command.application.dto.ChangePasswordDTO;
import com.piveguyz.ondambackend.member.command.application.dto.MemberDTO;
import com.piveguyz.ondambackend.member.command.application.dto.UpdateAuthorityDTO;
import com.piveguyz.ondambackend.member.command.domain.aggregate.MemberEntity;
import com.piveguyz.ondambackend.member.command.domain.repository.MemberRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class MemberCommandServiceImpl implements MemberService {

    MemberRepository memberRepository;
    ModelMapper modelMapper;

    @Autowired
    public MemberCommandServiceImpl(MemberRepository memberRepository,
                                    ModelMapper modelMapper
    ) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;

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

        member.setDeletedAt(new Date()); // java.util.Date 현재시간
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

   }



