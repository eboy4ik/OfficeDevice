<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h2>Пользователи</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Логин</th>
        <th>Роль</th>
        <th>Имя</th>
        <th>Дата регистрации</th>
        <th>Заблокирован</th>
        <th>Авторизован</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.role.name}</td>
            <td>${user.name}</td>
            <td>${user.dateRegistration}</td>
            <td><c:if test="${user.isBlocked}">
                Заблокирован
            </c:if></td>
            </td>
            <td>
                <c:if test="${user.isAuthorized}">
                    В сети
                </c:if></td>
            <td>
                <form action="/controller" method="post" style="display: inline;">
                    <input type="hidden" name="command" value="blockUser">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="submit" value="Заблокировать">
                </form>
                <form action="/controller" method="post" style="display: inline;">
                    <input type="hidden" name="command" value="unblockUser">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="submit" value="Разблокировать">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
