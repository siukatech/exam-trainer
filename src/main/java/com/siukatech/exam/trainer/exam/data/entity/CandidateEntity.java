package com.siukatech.exam.trainer.exam.data.entity;

import com.siukatech.exam.trainer.web.model.ExamType;
import com.siukatech.poc.react.backend.core.data.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name = "candidates")
public class CandidateEntity extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

//    @OneToMany
//    @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
//    private Set<ExamEntity> exams;

}
