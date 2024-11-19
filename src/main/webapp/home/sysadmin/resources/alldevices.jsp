<!-- users.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Устройства</h2>

<button type="button"
        onclick="openDeviceCreateModal()">
    Добавить устройство
</button>

<table>

    <thead>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Дата появления</th>
        <th>Пользователь</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="device" items="${devicesList}">
        <tr>
            <td>${device.id}</td>
            <td>${device.name}</td>
            <td>${device.timeReceiving}</td>
            <td>${device.user.login}</td>
            <td>
                <form action="/controller" method="post" style="display: inline;"
                      onsubmit="return confirm(`Вы уверены что хотите удалить устройство ${device.name}?`)">
                    <input type="hidden" name="command" value="deleteDevice">
                    <input type="hidden" name="deviceId" value="${device.id}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="createDeviceModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal('createDeviceModal')">&times;</span>
        <h2>Добавить устройство</h2>
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="createDevice">

            <label>Название:</label>
            <input type="text" name="name"><br><br>

            <input type="submit" value="Сохранить">
        </form>
    </div>
</div>