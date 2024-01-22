<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Game - Game Over</title>
    <style>
        body {
            background-image: url('https://img.freepik.com/free-photo/space-background-realistic-starry-night-cosmos-and-shining-stars-milky-way-and-stardust-color-galaxy_1258-154750.jpg?w=1060&t=st=1705929851~exp=1705930451~hmac=9cf878881a5a1cd021ea5b61cb7ed94a4f4000ea8e6748fff90829cc66ed245d');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: #fff;
            text-align: center;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Game Over!</h1>
        <c:choose>
            <c:when test="${gameResult eq 'won'}">
                <p>Congratulations! You won the game.</p>
            </c:when>
            <c:when test="${gameResult eq 'lost'}">
                <p>Game over. You lost.</p>
            </c:when>
        </c:choose>
        <a href="${pageContext.request.contextPath}/start-game">Start again</a>
    </div>
</body>
</html>
