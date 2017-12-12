<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <h2 class="center">
        <a href="/news">Новости</a>
        <a href="/patches">Патч-ноуты</a>
        <a href="/cards">Карты</a>

        <%--TODO Я бы выделил блок "текущего юзера" в отдельный тайл, ибо он логически отделен от "меню" Ну и собственно можно его тут заинсертить как тайл, раз уж он пока что посреди менюшки отображается --%>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <a href="/loginPage">Вход</a>
                <br />
            </c:when>
            <c:otherwise>
                ${sessionScope.user}<a href="/loginPage/logout">(выйти)</a>
                <br />
            </c:otherwise>
        </c:choose>
    </h2>
</nav>