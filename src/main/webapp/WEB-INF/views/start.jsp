<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Game</title>
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
        .start-button {
            background-color: white;
            color: #333;
            padding: 15px 30px;
            font-size: 18px;
            border-radius: 8px;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
        .input-name {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the text game!</h1>
            <form action="${pageContext.request.contextPath}/start-game" method="post">
                <p>Please enter your name!:</p>
                <input type="text" name="userName" required class="input-name">
                <br>
                <input type="submit" name="startGame" value="Start the game!" class="start-button">
            </form>
    </div>
</body>
</html>
