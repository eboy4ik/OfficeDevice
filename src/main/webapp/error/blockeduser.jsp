<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вы заблокированы</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f4f4f4;
        }

        .container {
            margin-top: 100px;
        }

        h1 {
            color: #e67e22;
        }

        p {
            font-size: 18px;
            color: #333;
        }

        .btn {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Сессия завершена</h1>
    <p>Вы были заблокированы</p>
    <p>Выполните повторный вход</p>
    <a href="${pageContext.request.contextPath}/login.jsp" class="btn">Войти заново</a>
</div>
</body>
</html>
