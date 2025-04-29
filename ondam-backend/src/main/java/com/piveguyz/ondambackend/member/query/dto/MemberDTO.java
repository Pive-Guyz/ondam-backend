package com.piveguyz.ondambackend.member.query.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class
MemberDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private String phone;
    private String profileImageUrl;
    private String address;
    private Integer point;
    private String authority;
    private String isBanned;
    private String isDiaryBlocked;
}
