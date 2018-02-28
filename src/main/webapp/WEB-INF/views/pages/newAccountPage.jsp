<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div id="create_acc">
    <div class="container">
        <div class="sing_form">
            <form:form action="${pageContext.request.contextPath}/loginPage/createAccountPage"
                       commandName="registrationForm"
                       method="post">
                <div class="errors_block bold f8px">
                    <span class="error"><form:errors path="userLogin"/></span>
                    <span class="error"><form:errors path="userPassword"/></span>
                    <span class="error"><form:errors path="confirmPassword"/></span>
                    <span class="error"><form:errors path="userEmail"/></span>
                </div>
                <table align="center">
                    <tr>
                        <td>Username:</td>
                        <td><form:input path="userLogin"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><form:password path="userPassword"/></td>
                    </tr>
                    <tr>
                        <td>Confirm Password:</td>
                        <td><form:password path="confirmPassword"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><form:input path="userEmail"/></td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="submit" value="Submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>