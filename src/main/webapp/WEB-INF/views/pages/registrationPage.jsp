<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/registrationPage.css" />" rel="stylesheet">

<div id="create_acc">
    <div class="container">
        <div class="sing_form">
            <form:form onsubmit="return validateSingUpForm()" action="${pageContext.request.contextPath}/loginPage/registrationPage"
                       commandName="registrationForm"
                       method="post">
                <div class="errors_block bold f8px">
                    <span id="errorJS"></span>
                    <span class="error"><form:errors path="userLogin"/></span>
                    <span class="error"><form:errors path="userPassword"/></span>
                    <span class="error"><form:errors path="confirmPassword"/></span>
                    <span class="error"><form:errors path="userEmail"/></span>
                </div>
                <table align="center">
                    <tr>
                        <td>Username:</td>
                        <td><form:input id="userLogin" path="userLogin"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><form:password id="userPass" path="userPassword"/></td>
                    </tr>
                    <tr>
                        <td>Confirm Password:</td>
                        <td><form:password id="confirmPass" path="confirmPassword"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><form:input id="email" path="userEmail"/></td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="submit" value="Submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
