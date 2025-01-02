package com.siukatech.exam.trainer.exam.data.repository;

import com.siukatech.exam.trainer.exam.data.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, UUID> {
}
