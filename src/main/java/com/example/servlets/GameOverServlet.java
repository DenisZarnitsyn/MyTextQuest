package com.example.servlets;

import com.example.games.GameProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameOverServlet", urlPatterns = {"/game-over"})
public class GameOverServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/game_over.jsp");

        // Додаємо дані до атрибутів перед передачею
        request.setAttribute("gameResult", ((GameProcessor) request.getSession().getAttribute("gameProcessor")).getGameResult());
        request.setAttribute("winnerName", ((GameProcessor) request.getSession().getAttribute("gameProcessor")).getWinnerName());

        dispatcher.forward(request, response);
    }
}

