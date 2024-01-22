package com.example.game;

import com.example.model.Option;
import com.example.model.Question;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.util.QuestionLoader;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class GameProcessor {
    private static final Logger logger = LoggerFactory.getLogger(GameProcessor.class);

    private List<Question> questions;
    private int currentQuestionIndex;
    @Setter private String playerName;
    private HttpServletRequest request;

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public GameProcessor() {
        List<Question> loadedQuestions = QuestionLoader.loadQuestions();

        if (Objects.nonNull(loadedQuestions) && !loadedQuestions.isEmpty()) {
            this.questions = loadedQuestions;
            this.currentQuestionIndex = 0;
        } else {
            logger.error("Failed to load questions. The game cannot be initialized.");
        }
    }

    public Question getCurrentQuestion() {
        if (isInvalidState()) {
            return null;
        }

        return questions.get(currentQuestionIndex);
    }

    public void processAnswer(int optionIndex) {
        if (isInvalidState() || isInvalidOptionIndex(optionIndex)) {
            return;
        }

        Option selectedOption = getCurrentQuestion().getOptions().get(optionIndex - 1);

        if (selectedOption.getNextQuestionId() == -1) {
            handleGameOver();
        } else if (selectedOption.getNextQuestionId() == 0) {
            handleGameWin();
        } else {
            moveToNextQuestion(selectedOption.getNextQuestionId());
        }
    }

    private boolean isInvalidState() {
        return questions == null || questions.isEmpty() || currentQuestionIndex < 0 || currentQuestionIndex >= questions.size();
    }

    private boolean isInvalidOptionIndex(int optionIndex) {
        if (optionIndex < 1 || optionIndex > getCurrentQuestion().getOptions().size()) {
            logger.warn("Invalid option index: {}", optionIndex);
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return questions == null || questions.isEmpty() || currentQuestionIndex >= questions.size();
    }

    private void moveToNextQuestion(int nextQuestionId) {
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getId() == nextQuestionId) {
                currentQuestionIndex = i;
                break;
            }
        }
    }

    private void handleGameOver() {
        endGame(false);
        request.setAttribute("gameResult", "lost");
    }

    private void handleGameWin() {
        endGame(true);
        request.setAttribute("gameResult", "won");
    }

    private void endGame(boolean isGameWon) {
        questions.clear();
        currentQuestionIndex = 0;

        if (isGameWon) {
            logger.info("Congratulations! You won the game.");
        } else {
            logger.info("Game over. You lost.");
        }
    }
}
