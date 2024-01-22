package com.example.utils;

import com.example.models.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QuestionLoader {
    private static final Logger logger = LoggerFactory.getLogger(QuestionLoader.class);

    public static List<Question> loadQuestions() {
        List<Question> questions = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = QuestionLoader.class.getResourceAsStream("/questions.json")) {
            if (inputStream != null) {
                questions = objectMapper.readValue(inputStream, new TypeReference<List<Question>>() {
                });
                logger.info("Successfully loaded the questions.json file.");
            } else {
                logger.error("Unable to find questions.json file.");
            }
        } catch (IOException e) {
            logger.error("Error loading questions: {}", e.getMessage(), e);
        }

        return questions != null ? questions : List.of();
    }
}
