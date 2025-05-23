package com.piveguyz.ondambackend.member.command.domain.repository;

import com.piveguyz.ondambackend.member.command.domain.aggregate.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByIdAndDeletedAtIsNull(Long id);

}
