<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <a href="/controller?command=viewFreeDevices">Доступные устройства</a>
    <a href="/controller?command=viewUserQueries">Заявки</a>
    <a href="/controller?command=viewUserDevices">Используемые устройства</a>

    <div class="user-info">
        <span class="user-name">${sessionScope.get("user").name}</span>
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="logOut">
            <input type="submit" value="Выход">
        </form>
    </div>
</nav>
<hr>