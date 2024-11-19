<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Используемые устройства</h2>

<table>

    <thead>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="device" items="${devicesList}">
        <tr>
            <td>${device.id}</td>
            <td>${device.name}</td>
            <td>
                <button type="button"
                        onclick="openUserQueryModal('${sessionScope.get("user").id}', '${device.id}', '${device.name}', 'return', 'Вернуть')">
                    Вернуть
                </button>
                <button type="button"
                        onclick="openUserQueryModal('${sessionScope.get("user").id}', '${device.id}', '${device.name}', 'repair', 'Починить')">
                    Починить
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="createQueryModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal('createQueryModal')">&times;</span>
        <h2><span id="question"></span>?</h2>
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="createQuery">
            <input type="hidden" id="deviceId" name="deviceId">
            <input type="hidden" id="userId" name="userId">
            <input type="hidden" id="queryType" name="queryType">

            <label for="message">Сообщение:</label>
            <input type="text" id="message" name="message" value=""><br><br>

            <input type="submit" value="Отправить">
        </form>
    </div>
</div>