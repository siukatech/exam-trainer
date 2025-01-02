package com.siukatech.exam.trainer.exam.data.entity;

import com.siukatech.exam.trainer.web.model.ExamType;
import com.siukatech.poc.react.backend.parent.data.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "exams")
public class ExamEntity extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @Column(name = "exam_type")
    private ExamType examType;

    @Column(name = "start_datetime")
    private LocalDateTime startDatetime;

    @Column(name = "end_datetime")
    private LocalDateTime endDatetime;

    @ManyToOne
    @JoinColumn( // this will add a candidate_id column to the exams table as a foreign key
            name = "candidate_id", // specifies the name of the foreign key column in the database
            referencedColumnName = "id" // primary key of the candidate who owns this Exam
    )
    public CandidateEntity candidate;

    @OneToMany(mappedBy = "exam")
    private List<AnswerEntity> answers;

}
