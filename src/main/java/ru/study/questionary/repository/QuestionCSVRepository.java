package ru.study.questionary.repository;


import org.springframework.stereotype.Component;
import ru.study.questionary.entity.Question;
import ru.study.questionary.reader.CSVQuestionReader;
import ru.study.questionary.reader.QuestionReader;

import java.util.List;

@Component
public class QuestionCSVRepository implements QuestionRepository {

    private QuestionReader reader;

    public QuestionCSVRepository(CSVQuestionReader reader) {
        this.reader = reader;
    }

    @Override
    public Question getQuestion() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Question> getAll() {
        return reader.readQuestions();
    }


}
