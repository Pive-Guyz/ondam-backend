package com.piveguyz.ondambackend.diary.command.domain.repository;

import com.piveguyz.ondambackend.diary.command.domain.aggregate.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findTopByOrderByIdDesc();
    // 추가적인 메소드 구현이 필요하다면 여기에 추가

}
