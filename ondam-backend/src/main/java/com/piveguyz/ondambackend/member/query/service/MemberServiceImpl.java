package com.piveguyz.ondambackend.member.query.service;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import com.piveguyz.ondambackend.member.query.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberQueryService {
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberQueryDTO> selectAllMembers() {
        List<MemberQueryDTO> memberDTOList = memberMapper.findAllMembers();
        return memberDTOList;
    }

    @Override
    public MemberQueryDTO loginMember(String email, String password) {
        return  memberMapper.findMemberByEmailAndPassword(email, password);
    }
    @Override
    public MemberQueryDTO findMemberById(Long id)
    { // ★ 추가
        return memberMapper.findMemberById(id);
    }

    @Override
    public MemberQueryDTO findMemberByNameAndPhone(String name, String phone) {
        System.out.println(">>> name = " + name);
        System.out.println(">>> phone = " + phone);
        return memberMapper.findMemberByNameAndPhone(name, phone);
    }

    @Override
    public MemberQueryDTO findMemberByNameAndEmail(String name, String email) {
        return memberMapper.findMemberByNameAndEmail(name, email);
    }

}
