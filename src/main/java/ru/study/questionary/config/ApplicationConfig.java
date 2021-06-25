package ru.study.questionary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.study.questionary.reader.CSVQuestionReader;
import ru.study.questionary.repository.QuestionCSVRepository;
import ru.study.questionary.repository.QuestionRepository;
import ru.study.questionary.runner.ExamRunner;
import ru.study.questionary.service.QuestionService;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Bean
    public CSVQuestionReader reader() {
        return new CSVQuestionReader();
    }

    @Bean
    public QuestionRepository repository(CSVQuestionReader reader) {
        return new QuestionCSVRepository(reader);
    }

    @Bean
    public QuestionService questionService(QuestionRepository repository){
        return new QuestionService(repository);
    }

    @Bean
    public ExamRunner examRunner(QuestionService questionService) { return new ExamRunner(questionService);
    }

}
