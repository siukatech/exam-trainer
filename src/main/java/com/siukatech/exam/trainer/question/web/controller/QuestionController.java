package com.siukatech.exam.trainer.question.web.controller;

import com.siukatech.exam.trainer.web.api.QuestionApi;
import com.siukatech.exam.trainer.web.model.QuestionModel;
import com.siukatech.poc.react.backend.core.web.annotation.base.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestApiController
public class QuestionController implements QuestionApi {
    @Override
    public ResponseEntity<QuestionModel> createQuestion(QuestionModel questionModel) {
        return QuestionApi.super.createQuestion(questionModel);
    }

    @Override
    public ResponseEntity<QuestionModel> getQuestion(String questionId) {
        return QuestionApi.super.getQuestion(questionId);
    }

    @Override
    public ResponseEntity<Page> listQuestions(Pageable pageable) {
        return QuestionApi.super.listQuestions(pageable);
    }

    @Override
    public ResponseEntity<QuestionModel> updateQuestion(String questionId, QuestionModel questionModel) {
        return QuestionApi.super.updateQuestion(questionId, questionModel);
    }
}
