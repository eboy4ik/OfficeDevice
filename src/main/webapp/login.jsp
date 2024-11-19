<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Авторизация</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginstyles.css">
</head>
<body>
<div class="login-container">
	<h2>Авторизация</h2>
	<form name="loginForm" method="POST" action="controller"  accept-charset="UTF-8">
		<input type="hidden" name="command" value="login" />
		<label for="login">Логин:</label><br />
		<input type="text" id="login" name="login" value="" /><br />

		<label for="password">Пароль:</label><br />
		<input type="password" id="password" name="password" value="" /><br />

		<div class="error-messages">
			<span>${errorLoginPassMessage}</span><br />
			<span>${wrongAction}</span><br />
			<span>${nullPage}</span><br />
		</div>

		<input type="submit" value="Войти" />
	</form>
</div>
</body>
</html>
