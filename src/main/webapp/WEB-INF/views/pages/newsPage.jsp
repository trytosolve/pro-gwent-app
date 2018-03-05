<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/newsPage.css" />" rel="stylesheet">

<div id="news">
    <c:forEach items="${newsList}" var="news">
        ${news.postDate}
        <a href=${pageContext.request.contextPath}/news/${news.id}>${news.name}</a><br>
        ${news.description}<br>
    </c:forEach>
</div>