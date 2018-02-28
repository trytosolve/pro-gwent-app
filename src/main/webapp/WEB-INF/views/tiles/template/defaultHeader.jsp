<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container clearfix">
    <div class="row">
        <a href="/" class="col-md-2">
            <div class="logo f25px bold upper">
                <span>pr</span><i class="fa fa-circle"></i><span>gwent</span>
            </div>
        </a>
        <div class="col-md-5">
            <nav>
                <ul class="menu bold">
                    <li>
                        <a href="/news">News</a>
                    </li>
                    <li>
                        <a href="/patches">Patches</a>
                    </li>
                    <li>
                        <a href="/cards">Cards Database</a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-3">
            <div class="search_container">
                <form>
                    <input type="text" class="search" placeholder="Site Search">
                </form>
            </div>
        </div>
        <div class="col-md-2">
            <div class="sing f14px">
                <c:choose>
                    <c:when test="${empty sessionScope.user.login}">
                        <a href="/loginPage">Sign in</a>
                        <span>or</span>
                        <a href="/loginPage/createAccountPage">Sign up</a>
                    </c:when>
                    <c:otherwise>
                        <span class="bold f15px">${sessionScope.user.login}:</span>
                        <a href="/loginPage/logout">logout</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
