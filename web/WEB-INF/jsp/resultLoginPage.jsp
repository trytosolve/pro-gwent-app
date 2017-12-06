<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IRedko
  Date: 06.12.2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="utf-8">
        <title>Result login page</title>
        <style>
            .center {
                text-align: center;
            }
        </style>
    </head>
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
<div>${result}</div>

</body>
</html>
