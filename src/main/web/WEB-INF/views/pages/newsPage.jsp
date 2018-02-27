<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${newsList}" var="news">
    ${news.postDate}
    <a href=${pageContext.request.contextPath}/news/${news.id}>${news.name}</a><br>
    ${news.description}<br>
</c:forEach>
