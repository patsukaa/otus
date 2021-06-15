package ru.study.questionary.repository;


import ru.study.questionary.entity.Question;

import java.util.List;

public interface QuestionRepository {

    Question getQuestion();

    List<Question> getAll();


}
