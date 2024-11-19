<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Заявки</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Устройство</th>
        <th>Время отправки</th>
        <th>Время закрытия</th>
        <th>Тип запроса</th>
        <th>Статус запроса</th>
        <th>Сообщение</th>
        <th>Ответ</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="query" items="${queriesList}">
        <tr>
            <td>${query.id}</td>
            <td>${query.device.name}</td>
            <td>${query.timeSending}</td>
            <td>${query.timeClosing}</td>
            <td>${query.queryType.name}</td>
            <td>${query.queryStatus.name}</td>
            <td>${query.userMessage}</td>
            <td>${query.response}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

