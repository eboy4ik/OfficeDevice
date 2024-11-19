<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Заявки</h2>

<table>

    <thead>
    <tr>
        <th>ID</th>
        <th>Устройство</th>
        <th>Отправитель</th>
        <th>Время отправки</th>
        <th>Время закрытия</th>
        <th>Тип запроса</th>
        <th>Статус запроса</th>
        <th>Сообщение</th>
        <th>Ответ</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="query" items="${queriesList}">
        <tr>
            <td>${query.id}</td>
            <td>${query.device.name}</td>
            <td>${query.sender.login}</td>
            <td>${query.timeSending}</td>
            <td>${query.timeClosing}</td>
            <td>${query.queryType.name}</td>
            <td>${query.queryStatus.name}</td>
            <td>${query.userMessage}</td>
            <td>${query.response}</td>
            <td>
                <c:if test="${query.timeClosing == null}">
                    <button type="button"
                            onclick="openRespondQueryModal('${query.id}', '${query.device.name}', '${query.sender.login}', '${query.sender.id}', '${query.device.id}', '${query.queryType.name}', '${query.userMessage}')">
                        Ответить
                    </button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%-- Запрос устройства --%>
<div id="respondGetQueryModal" class="modal" style="display:none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal('respondGetQueryModal')">&times;</span>
        <h2>Ответ на запрос</h2>

        <form action="/controller" method="post">
            <input type="hidden" id="getCommand" name="command" value="">
            <input type="hidden" id="getQueryId" name="queryId">
            <input type="hidden" id="getSenderId" name="userId">
            <input type="hidden" id="getDeviceId" name="deviceId">


            <label>Отправитель:</label>
            <span id="getSender"></span><br><br>
            <label>Устройство:</label>
            <span id="getDevice"></span><br><br>

            <label>Тип запроса:</label>
            <span id="getQueryType"></span><br><br>

            <label>Сообщение пользователя:</label>
            <span id="getUserMessage"></span><br><br>

            <label>Ответ:</label><br>
            <textarea name="response"></textarea><br><br>

            <button type="button" onclick="submitForm('respondGetQueryModal', 'giveDevice')">Выдать устройство</button>
            <button type="button" onclick="submitForm('respondGetQueryModal', 'refuseGiveDevice')">Отказать</button>
        </form>
    </div>
</div>

<%-- Починить устройство --%>
<div id="respondRepairQueryModal" class="modal" style="display:none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal('respondRepairQueryModal')">&times;</span>
        <h2>Ответ на запрос</h2>

        <form action="/controller" method="post">
            <input type="hidden" id="repairCommand" name="command" value="">
            <input type="hidden" id="repairQueryId" name="queryId">
            <input type="hidden" id="repairSenderId" name="userId">
            <input type="hidden" id="repairDeviceId" name="deviceId">

            <label>Отправитель:</label>
            <span id="repairSender"></span><br><br>
            <label>Устройство:</label>
            <span id="repairDevice"></span><br><br>

            <label>Тип запроса:</label>
            <span id="repairQueryType"></span><br><br>

            <label>Сообщение пользователя:</label>
            <span id="repairUserMessage"></span><br><br>

            <label>Ответ:</label><br>
            <textarea name="response"></textarea><br><br>

            <button type="button" onclick="submitForm('respondRepairQueryModal', 'repairDevice')">Починено</button>
            <button type="button" onclick="submitForm('respondRepairQueryModal', 'refuseRepairDevice')">Не ремонтопригодно</button>
        </form>
    </div>
</div>

<%-- Отказ от устройства --%>
<div id="respondReturnQueryModal" class="modal" style="display:none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal('respondReturnQueryModal')">&times;</span>
        <h2>Ответ на запрос</h2>

        <form action="/controller" method="post">
            <input type="hidden" id="returnCommand" name="command" value="">
            <input type="hidden" id="returnQueryId" name="queryId">
            <input type="hidden" id="returnSenderId" name="userId">
            <input type="hidden" id="returnDeviceId" name="deviceId">

            <label>Отправитель:</label>
            <span id="returnSender"></span><br><br>
            <label>Устройство:</label>
            <span id="returnDevice"></span><br><br>

            <label>Тип запроса:</label>
            <span id="returnQueryType"></span><br><br>

            <label>Сообщение пользователя:</label>
            <span id="returnUserMessage"></span><br><br>

            <label>Ответ:</label><br>
            <textarea name="response"></textarea><br><br>

            <button type="button" onclick="submitForm('respondReturnQueryModal', 'acceptDevice')">Принять устройство</button>
            <button type="button" onclick="submitForm('respondReturnQueryModal', 'refuseAcceptDevice')">Отказать</button>
        </form>
    </div>
</div>