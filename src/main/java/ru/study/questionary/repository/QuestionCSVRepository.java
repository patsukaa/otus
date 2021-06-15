package ru.study.questionary.repository;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.study.questionary.entity.Question;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
public class QuestionCSVRepository implements QuestionRepository {


    private List<Question> questions = new ArrayList<>();

    @Setter
    private String fileName;

    @Override
    public Question getQuestion() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }


    //Post construct
    private void initQuestions() {
        try {

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator('@')
                    .withIgnoreQuotations(true)
                    .build();

            Reader reader = Files.newBufferedReader(
                    Paths.get(
                            ClassLoader.getSystemResource(fileName).toURI()
                    ));

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();

            List<Question> collect = csvReader.readAll()
                    .stream()
                    .map(cortege -> Question.builder()
                            .text(cortege[0])
                            .build())
                    .collect(toList());

            questions.addAll(collect);

            reader.close();
        } catch (Exception e) {
            log.error("Some exception happens", e);
        }
    }

}
