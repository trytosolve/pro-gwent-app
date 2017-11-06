<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IRedko
  Date: 03.11.2017
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gwent news</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
<h1 class=center>Gwent news</h1>
<div></div>

<c:forEach items="${newsList}" var="news">
    ${news.postDate}
    <a href=${pageContext.request.contextPath}/news/${news.id}>${news.name}</a><br>
    ${news.description}<br>
</c:forEach>

</body>
</html>