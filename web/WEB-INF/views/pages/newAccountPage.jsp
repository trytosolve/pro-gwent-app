<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/loginPage/createAccountPage" commandName="registrationForm"
           method="post">
    <table align="center">

        <tr>
                ${securityResult} <!-- TODO не вижу чтобы это где-то заполнялось в контроллере -->
        </tr>

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
            <td>Confirm Password:</td>
            <td><form:password path="confirmPassword"/></td>
            <td><span class="error"><form:errors
                    path="confirmPassword"/></span></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="userEmail"/></td>
            <td><span class="error"><form:errors path="userEmail"/></span></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>