package com.siukatech.exam.trainer.question.data.repository;

import com.siukatech.exam.trainer.question.data.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OptionRepository extends JpaRepository<OptionEntity, UUID> {
}
