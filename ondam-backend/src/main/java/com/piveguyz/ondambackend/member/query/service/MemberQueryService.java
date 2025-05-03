package com.piveguyz.ondambackend.member.query.service;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;

import java.util.List;

public interface MemberQueryService {
    List<MemberQueryDTO> selectAllMembers();

    MemberQueryDTO loginMember(String email, String password);

    MemberQueryDTO findMemberById(Long id);

    MemberQueryDTO findMemberByNameAndPhone(String name, String phone);

    MemberQueryDTO findMemberByNameAndEmail(String name, String email);
}
