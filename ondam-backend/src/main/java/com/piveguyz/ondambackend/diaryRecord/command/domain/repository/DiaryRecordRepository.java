package com.piveguyz.ondambackend.diaryRecord.command.domain.repository;

import com.piveguyz.ondambackend.diaryRecord.command.domain.aggregate.DiaryRecord;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRecordRepository extends JpaRepository<DiaryRecord, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE DiaryRecord dr SET dr.isExpired = 'Y' WHERE dr.isExpired = 'N'")
    int expireAllDiaryRecords();
}
