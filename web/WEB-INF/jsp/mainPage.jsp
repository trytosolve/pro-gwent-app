<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IRedko
  Date: 03.11.2017
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
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
<h1 class="center"> <a href="/">Gwent app</a></h1>

<h2 class="center">
    <a href="/news">Новости</a>
    <a href="/patches">Патч-ноуты</a>
    <a href="/cards">Карты</a>
    <c:choose>
        <c:when test="${empty sessionScope.USER}">
            <a href="/login">Вход</a>
            <br />
        </c:when>
        <c:otherwise>
            ${sessionScope.USER.name}<a href="/logout">(выйти)</a>
            <br />
        </c:otherwise>
    </c:choose>
</h2>
</body>
</html>
