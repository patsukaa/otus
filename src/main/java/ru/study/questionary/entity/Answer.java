package ru.study.questionary.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Answer {
    @Getter
    public Question question;
    @Getter
    public String answer;
}
