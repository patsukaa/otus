package ru.study.questionary.reader;

import ru.study.questionary.entity.Question;

import java.util.List;

public interface QuestionReader {
    List<Question> readQuestions();
}
