package com.piveguyz.ondambackend.counsel.command.domain.aggregate.entity;

import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselContent;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselOpinion;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselTime;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.Weather;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "counsel")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CounselEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime nextCreatedAt;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT"))
    private CounselContent content;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "opinion", nullable = false, columnDefinition = "LONGTEXT"))
    private CounselOpinion opinion;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "weather", nullable = false))
    private Weather weather;

    private String counselType;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "time", nullable = false))
    private CounselTime time;

    private LocalDateTime deletedAt;

    @Column(nullable = false)
    private Long counseleeId;

    @Column(nullable = false)
    private Long memberId;

    @Builder
    public CounselEntity(CounselContent content, CounselOpinion opinion, Weather weather, 
                        CounselTime time, Long counseleeId, Long memberId, LocalDateTime nextCreatedAt, String counselType) {
        this.content = content;
        this.opinion = opinion;
        this.weather = weather;
        this.time = time;
        this.counselType = counselType;
        this.counseleeId = counseleeId;
        this.memberId = memberId;
        this.createdAt = LocalDateTime.now();
        this.nextCreatedAt = nextCreatedAt;
        this.deletedAt = null;
    }

    public void update(CounselContent content, CounselOpinion opinion, Weather weather, 
                      CounselTime time, LocalDateTime nextCreatedAt, String counselType) {
        this.content = content;
        this.opinion = opinion;
        this.weather = weather;
        this.counselType = counselType;
        this.time = time;
        this.nextCreatedAt = nextCreatedAt;
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }

    public void updateNextCounselDate(LocalDateTime nextCreatedAt) {
        this.nextCreatedAt = nextCreatedAt;
    }
}