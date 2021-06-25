package ru.study.questionary.entity;

import lombok.Builder;
import lombok.Getter;

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
