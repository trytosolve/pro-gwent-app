<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/cardPage.css" />" rel="stylesheet">

<div id="card_db">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="search_card_form">
                    <form:form action="${pageContext.request.contextPath}/cards" modelAttribute="searchForm"
                               method="post">
                        <div class="search_card fon">
                            Search Card:<form:input path="searchParam"/>
                        </div>
                        <div class="types_filter fon">
                            <c:forEach items="${possibleTypes}" var="type">
                                <div>
                                    <form:checkbox path="typesSet" value="${type}"/><span>${type.description}</span>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="faction_filter fon">
                            <c:forEach items="${possibleFactions}" var="faction">
                                <div>
                                    <form:checkbox path="factionsSet" value="${faction}"/><span>${faction.description}</span>
                                </div>
                            </c:forEach>
                        </div>
                        <div>
                            <input type="submit" value="Find" class="fon">
                        </div>
                    </form:form>
                </div>
            </div>
            <div class="col-md-8">
                <div class="search_card_result">
                    <c:forEach items="${cardList}" var="card">
                        <div class="one_result_card fon">
                            <div class="card_img">
                                <img src="${card.url}" alt="">
                            </div>
                            <div class="card_param">
                                <ul>
                                    <li>NAME: ${card.name}</li>
                                    <li>TYPE: ${card.type}</li>
                                    <li>FACTION: ${card.faction}</li>
                                    <li>DESCRIPTION ${card.discription}</li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>