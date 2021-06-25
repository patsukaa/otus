package ru.study.questionary.runner;

import org.springframework.stereotype.Component;
import ru.study.questionary.entity.Answer;
import ru.study.questionary.entity.Exam;
import ru.study.questionary.entity.Question;
import ru.study.questionary.entity.Student;
import ru.study.questionary.service.QuestionService;

import java.util.List;
import java.util.Scanner;

@Component
public class ExamRunner {

    private QuestionService service;

    public ExamRunner(QuestionService service) {
        this.service = service;
    }

    public void run() {
        System.out.println("Какая у тебя фамилия?");
        Scanner console = new Scanner(System.in);
        String firstName = console.nextLine();

        System.out.println("Как тебя зовут?");
        String name = console.nextLine();

        Student student = Student.builder()
                .firstName(firstName)
                .name(name)
                .build();

        List<Question> questions = service.getQuestions();


        Exam exam = Exam.builder()
                .student(student)
                .build();

        questions
                .forEach(question -> {
                    System.out.println(question.getText());
                    String answer = console.nextLine();

                    exam.getAnswers().add(
                            Answer.builder()
                                    .question(question)
                                    .answer(answer)
                                    .build()
                    );

                });

        int count = exam.getAnswers().size();
        long rightAnswersCount = exam.getAnswers()
                .stream()
                .filter(answer -> answer.question.getCorrectAnswer().equalsIgnoreCase(answer.answer))
                .count();


        System.out.format("Студент %s ответил правильно на %d из %d вопросов", exam.getStudent().getFirstName(), rightAnswersCount, count);

    }
}
