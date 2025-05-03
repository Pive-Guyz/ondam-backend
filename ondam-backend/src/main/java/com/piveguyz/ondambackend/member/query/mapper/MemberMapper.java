package com.piveguyz.ondambackend.member.query.mapper;

import com.piveguyz.ondambackend.member.query.dto.MemberQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberQueryDTO> findAllMembers(); // @Select 제거

    MemberQueryDTO findMemberById(Long id);

    MemberQueryDTO findMemberByNameAndPhone(@Param("name") String name, @Param("phone") String phone);

    MemberQueryDTO findMemberByNameAndEmail(@Param("name") String name, @Param("email") String email);

    MemberQueryDTO findMemberByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
