<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h2>Пользователи</h2>

<button type="button"
        onclick="openUserCreateModal()">
    Создать пользователя
</button>
<br>

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
                <form action="/controller" method="post" style="display: inline;"
                      onsubmit="return confirm(`Вы уверены что хотите удалить пользователя ${user.name}? Все заявки данного пользователя будут удалены, а устройства пользователя возвращены.`)">
                    <input type="hidden" name="command" value="deleteUser">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="submit" value="Удалить">
                </form>

                <button type="button"
                        onclick="openUserEditModal('${user.id}', '${user.name}')">
                    Редактировать
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="createUserModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal('createUserModal')">&times;</span>
        <h2>Создать пользователя</h2>
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="createUser">

            <label>Логин:</label>
            <input type="text" name="login"><br><br>

            <label>Пароль:</label>
            <input type="text" name="password"><br><br>

            <label>Имя:</label>
            <input type="text" name="name"><br><br>

            <label>Роль:</label>
            <select name="role">
                <option value="admin">Администратор</option>
                <option value="moderator">Модератор</option>
                <option value="sysadmin">Системный админ</option>
                <option value="office_employee" selected>Офисный работник</option>
            </select><br><br>
            <input type="submit" value="Сохранить">
        </form>
    </div>
</div>

<div id="editModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal('editModal')">&times;</span>
        <h2>Редактировать пользователя</h2>
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="editUser">
            <input type="hidden" id="userId" name="userId">
            <label>Имя:</label>
            <input type="text" id="name" name="name"><br><br>
            <label>Роль:</label>
            <select id="role" name="role">
                <option value="default" selected>Не менять</option>
                <option value="admin">Администратор</option>
                <option value="moderator">Модератор</option>
                <option value="sysadmin">Системный админ</option>
                <option value="office_employee">Офисный работник</option>
            </select><br><br>
            <input type="submit" value="Сохранить">
        </form>
    </div>
</div>
