package com.piveguyz.ondambackend.member;

import com.piveguyz.ondambackend.member.command.application.dto.ChangePasswordDTO;
import com.piveguyz.ondambackend.member.command.application.dto.MemberDTO;
import com.piveguyz.ondambackend.member.command.application.service.MemberCommandServiceImpl;
import com.piveguyz.ondambackend.member.command.domain.aggregate.MemberEntity;
import com.piveguyz.ondambackend.member.command.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberCommandTest {

    @Autowired
    MemberCommandServiceImpl memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void registMember() {
        // given
        MemberDTO dto = new MemberDTO();
        dto.setName("홍길동");
        dto.setEmail("hong1@test.com");
        dto.setPassword("1234");
        dto.setBirthday("2000-01-01");
        dto.setPhone("010-1111-2222");
        dto.setAddress("서울시 종로구");

        // when
        memberService.registMember(dto);

        // then
        MemberEntity saved = memberRepository.findAll()
                .stream()
                .filter(m -> m.getEmail().equals("hong1@test.com"))
                .findFirst()
                .orElse(null);

        assertNotNull(saved);
        assertEquals("홍길동", saved.getName());
        assertEquals("1234", saved.getPassword());
        assertEquals("2000-01-01", saved.getBirthday());
        assertEquals("010-1111-2222", saved.getPhone());
        assertEquals("서울시 종로구", saved.getAddress());
        assertEquals(30, saved.getPoint());
        assertEquals("GUEST", saved.getAuthority());
        assertEquals("N", saved.getIsBanned());
        assertEquals("N", saved.getIsDiaryBlocked());
    }

    @Test
    void deleteMember() {
        // given
        MemberEntity member = new MemberEntity();
        member.setName("홍길동");
        member.setEmail("hong1@test.com");
        member.setPassword("1234");
        member.setBirthday("2000-01-01");
        member.setPhone("010-1111-2222");
        member.setAddress("서울시 종로구");
        MemberEntity savedMember = memberRepository.save(member);

        // when
        memberService.deleteMember(savedMember.getId());

        // then
        MemberEntity deleted = memberRepository.findById(member.getId()).orElse(null);
        assertNotNull(deleted);
        assertNotNull(deleted.getDeletedAt());
    }

    @Test
    void changePassword() {
        // given
        MemberEntity member = new MemberEntity();
        member.setName("홍길동");
        member.setEmail("hong1@test.com");
        member.setPassword("oldpass");
        member.setBirthday("1990-01-01");
        member.setPhone("010-3333-3333");
        member.setAddress("서울시 강남구");
        memberRepository.save(member);

        ChangePasswordDTO dto = new ChangePasswordDTO();
        dto.setCurrentPassword("oldpass");
        dto.setNewPassword("newpass");
        dto.setNewPasswordCheck("newpass");

        // when
        memberService.changePassword(member.getId(), dto);

        // then
        MemberEntity updated = memberRepository.findById(member.getId()).get();
        assertEquals("newpass", updated.getPassword());
    }

}
