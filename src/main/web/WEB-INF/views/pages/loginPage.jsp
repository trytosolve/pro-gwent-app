<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/loginPage" modelAttribute="loginForm" method="post">
    <table align="center">

        <tr>
            <td>Username:</td>
            <td><form:input path="userLogin"/></td>
            <td><span class="error"><form:errors path="userLogin"/></span></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="userPassword"/></td>
            <td><span class="error"><form:errors path="userPassword"/></span></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit"/></td>
        </tr>
        <tr>
            <td><a href="/loginPage/createAccountPage">New account</a></td>
        </tr>
    </table>
</form:form>