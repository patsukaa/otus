package ru.study.questionary.runner;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Component;
import ru.study.questionary.entity.Answer;
import ru.study.questionary.entity.exam.Exam;
import ru.study.questionary.entity.Question;
import ru.study.questionary.entity.Student;
import ru.study.questionary.entity.exam.ExamResult;
import ru.study.questionary.service.QuestionService;

import java.util.List;
import java.util.Scanner;

@Component
public class ExamRunner {

    private QuestionService service;
    private ExamHelper helper;

    public ExamRunner(QuestionService service,
                      ExamHelper helper) {
        this.service = service;
        this.helper = helper;
    }

    public void run() {
        Scanner console = new Scanner(System.in);

        Student student = getStudent(console);

        List<Question> questions = service.getQuestions();

        Exam exam = runExam(console, student, questions);

        ExamResult examResult = helper.checkExam(exam);

        System.out.format("Студент %s ответил правильно на %d из %d вопросов",
                exam.getStudent().getFirstName(),
                examResult.getQuestionCount(),
                examResult.getRightAnswerCount());

    }

    private Student getStudent(Scanner scanner) {
        System.out.println("Какая у тебя фамилия?");
        String firstName = scanner.nextLine();
        System.out.println("Как тебя зовут?");
        String name = scanner.nextLine();

        return Student.builder()
                .firstName(firstName)
                .name(name)
                .build();
    }

    private Exam runExam(Scanner scanner, Student student, List<Question> questions) {
        Exam exam = Exam.builder()
                .student(student)
                .build();

        questions
                .forEach(question -> {
                    System.out.println(question.getText());
                    String answer = scanner.nextLine();

                    exam.getAnswers().add(
                            Answer.builder()
                                    .question(question)
                                    .answer(answer)
                                    .build()
                    );

                });
        return exam;
    }

}
