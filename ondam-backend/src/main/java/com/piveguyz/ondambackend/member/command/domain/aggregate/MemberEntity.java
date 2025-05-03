package com.piveguyz.ondambackend.member.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "profile_image_url", nullable = true)
    private String profileImageUrl;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "point", nullable = false)
    private Integer point = 30;

    @Column(name = "authority", nullable = false)
    private String authority = "GUEST";

    @Column(name = "is_banned", nullable = false)
    private String isBanned = "N";

    @Column(name = "is_diary_blocked", nullable = false)
    private String isDiaryBlocked = "N";





//    @Column(name = "encrypted_pwd", nullable = false)
//    private String encryptedPwd;


//    @Column(name = "member_id", nullable = false, unique = true) // 얘도 서버가 만들어준다
//    private String memberId;
}
