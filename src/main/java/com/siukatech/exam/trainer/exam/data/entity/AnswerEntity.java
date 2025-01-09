package com.siukatech.exam.trainer.exam.data.entity;

import com.siukatech.poc.react.backend.core.data.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "answers")
public class AnswerEntity extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne
    @JoinColumn(
            name = "exam_id",
            referencedColumnName = "id"
    )
    private ExamEntity exam;

}
