<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title><tiles:getAsString name="title" /></title>
</head>

<body>
<header id="header">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="login" />
</header>

<section id="sidemenu">
    <tiles:insertAttribute name="menu" />
</section>

<section id="site-content">
    <tiles:insertAttribute name="body" />
</section>

<footer id="footer">
    <tiles:insertAttribute name="footer" />
</footer>
<script src="https://use.fontawesome.com/0279959ac4.js"></script>
</body>
</html>