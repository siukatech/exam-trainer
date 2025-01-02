package com.siukatech.exam.trainer.exam.data.repository;

import com.siukatech.exam.trainer.exam.data.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, UUID> {
}
