package ru.study.questionary.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Student {

    @Getter
    private String firstName;

    @Getter
    private String name;
}
