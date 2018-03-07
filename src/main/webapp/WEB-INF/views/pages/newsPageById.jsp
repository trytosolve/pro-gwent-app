<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/newsPageById.css" />" rel="stylesheet">

<div id="solo_news">
    <div class="container">
        <div class="news_by_id fon">
            <div class="title_news_by_id">
                ${news.newsTitle}
            </div>
            <div class="body_news">
                ${news.newsBody}
            </div>
        </div>
    </div>
</div>