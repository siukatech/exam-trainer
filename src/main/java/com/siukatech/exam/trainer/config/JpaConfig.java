package com.siukatech.exam.trainer.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.siukatech.exam.trainer.*.data.entity"})
@EnableJpaRepositories("com.siukatech.exam.trainer.*.data.repository")
public class JpaConfig {

}
