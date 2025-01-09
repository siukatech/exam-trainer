package com.siukatech.exam.trainer.exam.web.controller;

import com.siukatech.exam.trainer.web.api.ExamApi;
import com.siukatech.exam.trainer.web.model.ExamModel;
import com.siukatech.poc.react.backend.core.web.annotation.base.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestApiController
public class ExamController implements ExamApi {
    @Override
    public ResponseEntity<ExamModel> createExam(ExamModel examModel) {
        return ExamApi.super.createExam(examModel);
    }

    @Override
    public ResponseEntity<ExamModel> getExam(String examId) {
        return ExamApi.super.getExam(examId);
    }

    @Override
    public ResponseEntity<Page> listExams(Pageable pageable) {
        return ExamApi.super.listExams(pageable);
    }

    @Override
    public ResponseEntity<ExamModel> updateExam(String examId, ExamModel examModel) {
        return ExamApi.super.updateExam(examId, examModel);
    }
}
