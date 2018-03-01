<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="login">
    <div class="container">
        <div class="sing_form">
            <form:form onsubmit="return validate();" action="${pageContext.request.contextPath}/loginPage" modelAttribute="loginForm" method="post">
                <div class="errors_block bold f8px">
                    <span class="error"><form:errors path="userLogin"/></span>
                    <span class="error"><form:errors path="userPassword"/></span>
                </div>
                <table class="clearfix" align="center">
                    <tr>
                        <td>Username:</td>
                        <td><form:input id="userLogin" path="userLogin"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><form:password id="userPassword" path="userPassword"/></td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="submit" value="Submit"/></td>
                    </tr>
                    <tr>
                        <td><a href="/loginPage/createAccountPage">New account</a></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>