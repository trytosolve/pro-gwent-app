<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/newsPage.css" />" rel="stylesheet">

<div id="news">
    <div class="container">
        <c:forEach items="${newsList}" var="news">
            <div class="one_news fon">
                <div class="news_creation_time">
                    ${news.createDateNews}
                </div>
                <div class="news_title">
                    <a href=${pageContext.request.contextPath}/news/${news.id}>${news.newsTitle}</a><br>
                </div>
                <div class="news_description">
                    ${news.newsDescription}
                </div>
            </div>
        </c:forEach>
    </div>
</div>
