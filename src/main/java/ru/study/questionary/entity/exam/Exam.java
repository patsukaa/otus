package ru.study.questionary.entity.exam;

import lombok.Builder;
import lombok.Getter;
import ru.study.questionary.entity.Answer;
import ru.study.questionary.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Exam {

    @Getter
    private Student student;

    @Getter
    @Builder.Default
    private List<Answer> answers = new ArrayList<>();
}
