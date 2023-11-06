package com.example.questionprompt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EntityScan("com.example.questionprompt.model")
@EnableJpaRepositories(basePackages = "com.example.questionprompt.repository")
public class QuestionPromptApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionPromptApplication.class, args);
	}

}
