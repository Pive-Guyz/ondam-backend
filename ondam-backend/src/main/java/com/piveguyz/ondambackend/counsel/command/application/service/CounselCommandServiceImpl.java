package com.piveguyz.ondambackend.counsel.command.application.service;

import com.piveguyz.ondambackend.common.exceptions.CounselNotFoundException;
import com.piveguyz.ondambackend.common.exceptions.CounseleeNotFoundException;
import com.piveguyz.ondambackend.counsel.command.application.dto.CounselCommandDTO;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselContent;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselOpinion;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.CounselTime;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.VO.Weather;
import com.piveguyz.ondambackend.counsel.command.domain.aggregate.entity.CounselEntity;
import com.piveguyz.ondambackend.counsel.command.domain.repository.CounselRepository;
import com.piveguyz.ondambackend.counselee.command.domain.repository.CounseleeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CounselCommandServiceImpl implements CounselCommandService {

    private final CounselRepository counselRepository;
    private final CounseleeRepository counseleeRepository;

    @Override
    public CounselCommandDTO.Response createCounsel(CounselCommandDTO.CreateRequest request) {
        validateExistence(request.getCounseleeId(), request.getMemberId());

        CounselEntity counsel = CounselEntity.builder()
                .content(CounselContent.from(request.getContent().getValue()))
                .opinion(CounselOpinion.from(request.getOpinion().getValue()))
                .weather(Weather.from(request.getWeather().getValue()))
                .counselType(request.getCounselType())
                .time(CounselTime.from(request.getTime().getValue()))
                .counseleeId(request.getCounseleeId())
                .memberId(request.getMemberId())
                .nextCreatedAt(request.getNextCreatedAt())
                .build();

        return CounselCommandDTO.Response.from(counselRepository.save(counsel));
    }

    @Override
    public CounselCommandDTO.Response updateCounsel(Long counselId, CounselCommandDTO.UpdateRequest request) {
        CounselEntity counsel = findCounselById(counselId);

        counsel.update(
                CounselContent.from(request.getContent().getValue()),
                CounselOpinion.from(request.getOpinion().getValue()),
                Weather.from(request.getWeather().getValue()),
                CounselTime.from(request.getTime().getValue()),
                request.getNextCreatedAt(),
                request.getCounselType()
        );

        return CounselCommandDTO.Response.from(counsel);
    }

    @Override
    public CounselCommandDTO.Response updateNextCounselDate(Long counselId, CounselCommandDTO.UpdateNextCounselDateRequest request) {
        CounselEntity counsel = findCounselById(counselId);
        counsel.updateNextCounselDate(request.getNextCreatedAt());

        return CounselCommandDTO.Response.from(counsel);
    }

    @Override
    public void deleteCounsel(Long counselId) {
        CounselEntity counsel = findCounselById(counselId);
        counsel.delete();
    }

    private CounselEntity findCounselById(Long counselId) {
        return counselRepository.findById(counselId)
                .orElseThrow(() -> new CounselNotFoundException(counselId));
    }

    private void validateExistence(Long counseleeId, Long memberId) {
        if (!counseleeRepository.existsById(counseleeId)) {
            throw new CounseleeNotFoundException(counseleeId);
        }
    }
}
