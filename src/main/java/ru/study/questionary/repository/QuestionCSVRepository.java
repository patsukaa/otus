package ru.study.questionary.repository;


import org.springframework.stereotype.Repository;
import ru.study.questionary.entity.Question;
import ru.study.questionary.reader.CSVQuestionReader;

import java.util.List;

@Repository
public class QuestionCSVRepository implements QuestionRepository {

    private CSVQuestionReader reader;

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
