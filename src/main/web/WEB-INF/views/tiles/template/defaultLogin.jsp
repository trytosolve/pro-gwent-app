<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${empty sessionScope.user.login}">
        <a href="/loginPage">Вход</a>
        <br />
    </c:when>
    <c:otherwise>
        ${sessionScope.user.login}<a href="/loginPage/logout">(выйти)</a>
        <br />
    </c:otherwise>
</c:choose>