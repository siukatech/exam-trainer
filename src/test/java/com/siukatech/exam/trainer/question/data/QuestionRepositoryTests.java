package com.siukatech.exam.trainer.question.data;


import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.UUIDGenerator;
import com.siukatech.exam.trainer.question.data.entity.OptionEntity;
import com.siukatech.exam.trainer.question.data.entity.QuestionEntity;
import com.siukatech.exam.trainer.question.data.repository.OptionRepository;
import com.siukatech.exam.trainer.question.data.repository.QuestionRepository;
import com.siukatech.poc.react.backend.parent.AbstractJpaTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
public class QuestionRepositoryTests extends AbstractJpaTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;


    private QuestionEntity prepareQuestionEntity_basic() {
        QuestionEntity questionEntity = new QuestionEntity();
////        questionEntity.setId(Generators.nameBasedGenerator().generate("questions"));
//        questionEntity.setId(UUID.randomUUID());
        questionEntity.setCreatedBy("admin");
        questionEntity.setCreatedDatetime(LocalDateTime.now());
        questionEntity.setLastModifiedBy("admin");
        questionEntity.setLastModifiedDatetime(LocalDateTime.now());
        questionEntity.setVersionNo(1L);
        return questionEntity;
    }

    private List<OptionEntity> prepareOptionEntity_basic(QuestionEntity questionEntity) {
        OptionEntity optionEntity1 = new OptionEntity();
////        optionEntity1.setId(Generators.nameBasedGenerator().generate("options"));
//        optionEntity1.setId(UUID.randomUUID());
        optionEntity1.setQuestion(questionEntity);
        optionEntity1.setCorrect(true);
        optionEntity1.setLabel("a");
        optionEntity1.setCreatedBy("admin");
        optionEntity1.setCreatedDatetime(LocalDateTime.now());
        optionEntity1.setLastModifiedBy("admin");
        optionEntity1.setLastModifiedDatetime(LocalDateTime.now());
        optionEntity1.setVersionNo(1L);
        //
        OptionEntity optionEntity2 = new OptionEntity();
////        optionEntity2.setId(Generators.nameBasedGenerator().generate("options"));
//        optionEntity2.setId(UUID.randomUUID());
        optionEntity2.setQuestion(questionEntity);
        optionEntity2.setCorrect(false);
        optionEntity2.setLabel("b");
        optionEntity2.setCreatedBy("admin");
        optionEntity2.setCreatedDatetime(LocalDateTime.now());
        optionEntity2.setLastModifiedBy("admin");
        optionEntity2.setLastModifiedDatetime(LocalDateTime.now());
        optionEntity2.setVersionNo(1L);

        List<OptionEntity> optionEntities = new ArrayList<>();
        optionEntities.add(optionEntity1);
        optionEntities.add(optionEntity2);
        return optionEntities;
    }

    @BeforeEach
    public void setup(TestInfo testInfo) {
        QuestionEntity questionEntity = this.prepareQuestionEntity_basic();
        log.debug("setup - questionEntity.getId: [{}] - 1", questionEntity.getId());
        QuestionEntity questionEntity1 = questionRepository.save(questionEntity);
        log.debug("setup - questionEntity1.getId: [{}] - 2", questionEntity1.getId());
        List<OptionEntity> optionEntities = this.prepareOptionEntity_basic(questionEntity1);
        optionRepository.saveAll(optionEntities);
    }

    @AfterEach
    public void teardown(TestInfo testInfo) {
//        QuestionEntity questionEntity = this.prepareQuestionEntity_basic();
//        List<OptionEntity> optionEntities = this.prepareOptionEntity_basic(questionEntity);
//        optionRepository.deleteAll(optionEntities);
//        questionRepository.delete(questionEntity);
        optionRepository.deleteAll();
        questionRepository.deleteAll();
    }

    @Test
    public void findAll_basic() {
        List<QuestionEntity> questionEntityList = questionRepository.findAll();
        assertThat(questionEntityList).filteredOn(questionEntity -> {
            log.debug("findAll_basic - questionEntity: [{}]", questionEntity);
            return questionEntity.getId().toString().contains("-");
        });
    }

}
