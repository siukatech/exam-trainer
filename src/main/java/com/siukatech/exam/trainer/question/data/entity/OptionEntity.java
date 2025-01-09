package com.siukatech.exam.trainer.question.data.entity;

import com.siukatech.exam.trainer.exam.data.entity.ExamEntity;
import com.siukatech.poc.react.backend.core.data.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "options")
public class OptionEntity extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String label;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(
            name = "question_id",
            referencedColumnName = "id"
    )
    private QuestionEntity question;

}
