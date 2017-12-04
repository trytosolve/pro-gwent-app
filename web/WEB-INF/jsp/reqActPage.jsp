<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Main page</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<h1 class="center">Gwent app</h1>

<h2 class="center">
    <a href="/news">Новости</a>
    <a href="/patches">Патч-ноуты</a>
    <a href="/cards">Карты</a>
    <c:choose>
        <c:when test="${session.getAttribute(User)==null}">
            <a href="/login">Вход</a>
            <br/>
        </c:when>
        <c:otherwise>
            ${session.getAttribute(USER).getName}
            <br/>
        </c:otherwise>
    </c:choose>
    Регистрация для ${user} успешна
</h2>
</body>
</html>
