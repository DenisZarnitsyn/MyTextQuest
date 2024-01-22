<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
        .options-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .radio-option {
            margin-bottom: 10px;
        }
        .submit-button {
            background-color: white;
            color: #333;
            padding: 15px 30px;
            font-size: 18px;
            border-radius: 8px;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Text game</h1>
        <p>${currentQuestion.question}</p>
        <form action="${pageContext.request.contextPath}/game" method="post" class="options-container">
            <c:forEach var="option" items="${currentQuestion.options}" varStatus="status">
                <div class="radio-option">
                    <input type="radio" id="option${status.index}" name="selectedOption" value="${status.index + 1}" required>
                    <label for="option${status.index}">${option.text}</label>
                </div>
            </c:forEach>
            <input type="submit" name="submitAnswer" value="Send" class="submit-button">
        </form>
        <a href="${pageContext.request.contextPath}/game-over">Game Over!</a>
    </div>
</body>
</html>
