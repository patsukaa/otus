package ru.study.questionary.reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.study.questionary.entity.Question;

import javax.annotation.PostConstruct;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Slf4j
public class CSVQuestionReader {

    @Value("${questionaryFile}")
    private String fileName;

    public List<Question> readQuestions() {
        if(fileName.isBlank() )
            throw new RuntimeException("File name cannot be blank");

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

            List<Question> questions = csvReader.readAll()
                    .stream()
                    .map(cortege -> Question.builder()
                            .text(cortege[0])
                            .correctAnswer(cortege[1])
                            .build())
                    .collect(toList());

            reader.close();
            return questions;
        } catch (Exception e) {
            log.error("Cannot read questions from resources", e);
            throw new RuntimeException("Cannot read questions from resources", e);
        }
    }

}
