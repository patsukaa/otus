package ru.study.questionary.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Question {

    @Getter
    private String text;

}
