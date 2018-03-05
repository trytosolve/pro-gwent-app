<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<c:url value="/resources/js/tinymce/tinymce.min.js"/>"></script>
<script>tinymce.init({ selector:'textarea' });</script>

<form action="${pageContext.request.contextPath}/newsCreator" method="post">
    <div>
        <textarea cols="80" rows="10">
        </textarea>
        <input type="submit" value="Submit"/>
    </div>
</form>

