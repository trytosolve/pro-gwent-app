<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/newsCreator.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/js/tinymce/tinymce.min.js"/>"></script>
<script>tinymce.init({ height :"100",selector :'.textarea1' });</script>
<script>tinymce.init({ height :"340",selector :'.textarea2' });</script>



<c:choose>
    <c:when test="${empty sessionScope.user.login}">
        <div class="access_denied">Access Denied</div>
    </c:when>
    <c:otherwise>
        <div id="news_creator">
            <form:form action="${pageContext.request.contextPath}/newsCreator" modelAttribute="news" method="post">
                <div class="container">
                    <div class="create_news_title">
                        <p>Title:</p>
                        <form:input path="newsTitle"/>
                    </div>
                    <div class="create_news_description">
                        <p>Description:</p>
                        <form:textarea class="textarea1" path="newsDescription"/>
                    </div>
                    <div class="create_news_body">
                        <p>Article Body:</p>
                        <form:textarea class="textarea2" path="newsBody"/>
                    </div>
                    <div class="create_news_submit">
                        <input type="submit" value="Submit"/>
                    </div>
                </div>
            </form:form>
        </div>
    </c:otherwise>
</c:choose>


