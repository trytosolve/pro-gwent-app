<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/newsPage.css" />" rel="stylesheet">

<div id="news">
    <c:forEach items="${newsList}" var="news">
        ${news.createDateNews}
        <a href=${pageContext.request.contextPath}/news/${news.id}>${news.newsTitle}</a><br>
        ${news.newsDescription}<br>
    </c:forEach>
</div>