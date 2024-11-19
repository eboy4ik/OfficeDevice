<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <a href="/controller?command=moderatorViewUsers">Пользователи</a>
    <a href="/controller?command=moderatorViewQueries">Заявки</a>

    <div class="user-info">
        <span class="user-name">${sessionScope.get("user").name}</span>
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="logOut">
            <input type="submit" value="Выход">
        </form>
    </div>
</nav>
<hr>