package com.piveguyz.ondambackend.member.command.application.service;

import com.piveguyz.ondambackend.member.command.application.dto.ChangePasswordDTO;
import com.piveguyz.ondambackend.member.command.application.dto.MemberDTO;
import com.piveguyz.ondambackend.member.command.application.dto.UpdateAuthorityDTO;

public interface MemberService {
    void registMember(MemberDTO memberDTO);

    void deleteMember(Long id);

    void changePassword(Long id, ChangePasswordDTO newPassword);


    void updateAuthority(UpdateAuthorityDTO updateAuthorityDTO);

    void plusPoint(Long id);

    void minusPoint(Long id);

    String resetPasswordWithTemp(String name, String email);

}
