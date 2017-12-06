<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gwent news</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<h1 class="center"> <a href="/">Gwent app</a></h1>

<h2 class="center">
    <a href="/news">Новости</a>
    <a href="/patches">Патч-ноуты</a>
    <a href="/cards">Карты</a>
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
<div class="center">${text}</div>
</body>
</html>