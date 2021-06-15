package ru.study.questionary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.study.questionary.entity.Question;
import ru.study.questionary.service.QuestionService;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService service = context.getBean(QuestionService.class);

        List<Question> question = service.getQuestions();
        question.stream()
                .map(Question::getText)
                .forEach(log::info);

    }

}
