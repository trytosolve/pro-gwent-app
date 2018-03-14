<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value="/resources/css/newsPageById.css" />" rel="stylesheet">

<div id="solo_news">
    <div class="container">
        <div class="article fon">
            <div class="article_title">
                ${news.newsTitle}
            </div>
            <div class="article_body">
                ${news.newsBody}
            </div>
        </div>
    </div>
</div>