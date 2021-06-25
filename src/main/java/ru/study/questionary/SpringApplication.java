package ru.study.questionary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.study.questionary.runner.ExamRunner;

@ComponentScan
@Slf4j
public class SpringApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);

        ExamRunner service = context.getBean(ExamRunner.class);

        service.run();

    }

}
