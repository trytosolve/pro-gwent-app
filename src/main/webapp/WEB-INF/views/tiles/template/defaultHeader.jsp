<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<header>
    <div class="container">
        <div class="heading">
            <div class="logo f27px bold">
                <span>pr</span><i class="fa fa-circle"></i><span>gwent</span>
            </div>
            <div class="login">
                <form:form action="${pageContext.request.contextPath}/loginPage" modelAttribute="loginForm"
                           method="post">
                    <span class="error"><form:errors path="userLogin"/></span>
                    <span class="error"><form:errors path="userPassword"/></span>
                    <form:input type="text" path="userLogin" class="log_item" placeholder="Login"/>
                    <form:input type="password" path="userPassword" class="log_item" placeholder="Password"/>
                    <button type="submit" class="act">Login</button>
                </form:form>
            </div>
        </div>
    </div>
</header>

