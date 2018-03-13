<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/newsPageById.css" />" rel="stylesheet">

<div id="solo_news">
    <div class="container">
        <div class="news_by_id fon">
            <!-- TODO by_id не должно быть названием стиля. Это немного странно что стили знают как ищутся новости :D -->
            <div class="article_title">
                ${news.newsTitle}
            </div>
            <div class="body_news">
                ${news.newsBody}
            </div>
        </div>
    </div>
</div>