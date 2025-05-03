package com.piveguyz.ondambackend.counsel.command.application.dto;

import com.piveguyz.ondambackend.counsel.command.domain.aggregate.entity.CounselEntity;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselContent;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselOpinion;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselTime;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.Weather;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CounselCommandDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateRequest {
        @NotNull(message = "상담 내용은 필수입니다")
        private CounselContent content;

        @NotNull(message = "상담 소견은 필수입니다")
        private CounselOpinion opinion;

        @NotNull(message = "날씨 정보는 필수입니다")
        private Weather weather;

        @NotNull(message = "상담 시간은 필수입니다")
        private CounselTime time;

        @NotNull(message = "상담 유형은 필수입니다")
        private String counselType;

        @NotNull(message = "내담자 ID는 필수입니다")
        private Long counseleeId;

        @NotNull(message = "상담사 ID는 필수입니다")
        private Long memberId;

        private LocalDateTime nextCreatedAt;
        
        public static CreateRequest of(String content, String opinion, String weather, 
                                     String time, Long counseleeId, Long memberId, String counselType,
                                     LocalDateTime nextCreatedAt) {
            return CreateRequest.builder()
                    .content(CounselContent.from(content))
                    .opinion(CounselOpinion.from(opinion))
                    .weather(Weather.from(weather))
                    .time(CounselTime.from(time))
                    .counselType(counselType)
                    .counseleeId(counseleeId)
                    .memberId(memberId)
                    .nextCreatedAt(nextCreatedAt)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateRequest {
        @NotNull(message = "상담 내용은 필수입니다")
        private CounselContent content;

        @NotNull(message = "상담 소견은 필수입니다")
        private CounselOpinion opinion;

        @NotNull(message = "날씨 정보는 필수입니다")
        private Weather weather;

        @NotNull(message = "상담 유형은 필수입니다")
        private String counselType;

        @NotNull(message = "상담 시간은 필수입니다")
        private CounselTime time;

        private LocalDateTime nextCreatedAt;
        
        public static UpdateRequest of(String content, String opinion, String weather,
                                     String time, LocalDateTime nextCreatedAt, String counselType) {
            return UpdateRequest.builder()
                    .content(CounselContent.from(content))
                    .opinion(CounselOpinion.from(opinion))
                    .weather(Weather.from(weather))
                    .counselType(counselType)
                    .time(CounselTime.from(time))
                    .nextCreatedAt(nextCreatedAt)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateNextCounselDateRequest {
        @NotNull(message = "다음 상담 일정은 필수입니다")
        private LocalDateTime nextCreatedAt;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private String content;
        private String opinion;
        private String weather;
        private String time;
        private String counselType;
        private Long counseleeId;
        private Long memberId;
        private LocalDateTime createdAt;
        private LocalDateTime nextCreatedAt;
        private LocalDateTime deletedAt;

        public static Response from(CounselEntity entity) {
            return Response.builder()
                    .id(entity.getId())
                    .content(entity.getContent().getValue())
                    .opinion(entity.getOpinion().getValue())
                    .weather(entity.getWeather().getValue())
                    .time(entity.getTime().getValue())
                    .counselType(entity.getCounselType())
                    .counseleeId(entity.getCounseleeId())
                    .memberId(entity.getMemberId())
                    .createdAt(entity.getCreatedAt())
                    .nextCreatedAt(entity.getNextCreatedAt())
                    .deletedAt(entity.getDeletedAt())
                    .build();
        }
    }
}