package com.siukatech.exam.trainer.question.data.entity;

import com.siukatech.poc.react.backend.core.data.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "questions")
public class QuestionEntity extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<OptionEntity> options;

}
