package ru.study.questionary.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.study.questionary.SpringApplication;

@Configuration
@ComponentScan(basePackageClasses = SpringApplication.class)
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

}
