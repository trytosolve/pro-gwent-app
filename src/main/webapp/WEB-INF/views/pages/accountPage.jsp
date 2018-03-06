<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${empty sessionScope.user.login}">
        <div class="access_denied">Access Denied</div>
    </c:when>
    <c:otherwise>
        <a href="/newsCreator" class="bold f20px">Create news</a>
    </c:otherwise>
</c:choose>
