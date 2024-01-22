package com.example.servlet;

import com.example.game.GameProcessor;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameServlet", urlPatterns = {"/game"})
public class GameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameProcessor gameProcessor = (GameProcessor) request.getSession().getAttribute("gameProcessor");

        if (gameProcessor != null && !gameProcessor.isGameOver()) {
            request.setAttribute("currentQuestion", gameProcessor.getCurrentQuestion());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/game.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/start-game");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameProcessor gameProcessor = (GameProcessor) request.getSession().getAttribute("gameProcessor");

        if (gameProcessor != null) {
            gameProcessor.setRequest(request);
            int optionIndex = Integer.parseInt(request.getParameter("selectedOption"));
            gameProcessor.processAnswer(optionIndex);

            if (gameProcessor.isGameOver()) {
                response.sendRedirect(request.getContextPath() + "/game-over");
            } else {
                response.sendRedirect(request.getContextPath() + "/game");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/start-game");
        }
    }
}
