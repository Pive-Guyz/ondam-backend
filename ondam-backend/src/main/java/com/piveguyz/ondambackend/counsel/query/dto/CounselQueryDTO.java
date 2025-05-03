package com.piveguyz.ondambackend.counsel.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CounselQueryDTO {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime nextCreatedAt;
    private String content;
    private String opinion;
    private String weather;
    private String time;
    private String counselType;
    private LocalDateTime deletedAt;
    private Long counseleeId;
    private Long memberId;

    // 추가적으로 필요할 수 있는 조인 데이터
    private String counseleeName;  // 내담자 이름
    private String memberName;     // 상담사 이름
}