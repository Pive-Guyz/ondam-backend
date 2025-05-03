package com.piveguyz.ondambackend.analysis.command.domain.repository;

import com.piveguyz.ondambackend.analysis.command.domain.aggregate.EmotionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmotionCategoryRepository extends JpaRepository<EmotionCategory, Long> {
    boolean existsByName(String name);

    Optional<EmotionCategory> findByName(String oldName);
}