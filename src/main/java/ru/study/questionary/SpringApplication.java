package ru.study.questionary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import ru.study.questionary.config.ApplicationConfig;
import ru.study.questionary.runner.ExamRunner;

@Slf4j
@Import(ApplicationConfig.class)
public class SpringApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);

        ExamRunner service = context.getBean(ExamRunner.class);

        service.run();

    }

}
