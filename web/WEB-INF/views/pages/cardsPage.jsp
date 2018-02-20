<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form action="${pageContext.request.contextPath}/cards" modelAttribute="searchForm" method="post">
    <table align="left">

        <tr>
            <td>Search:</td>
            <td><form:input path="searchParam"/></td>
            <td><span class="error"><form:errors path="searchParam"/></span></td>
        </tr>


        <tr>
            <c:forEach items="${possibleTypes}" var="type">
                <td>
                    <form:checkbox path="typesList" value="${type}"/>${type.description}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <c:forEach items="${possibleFactions}" var="faction">
                <td>
                    <form:checkbox path="factionsList" value="${faction}"/>${faction.description}
                </td>
            </c:forEach>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Ok"/></td>
        </tr>
    </table>
</form:form>

<table>
    <c:forEach items="${cardList}" var="card">
        <tr>
            <td>
                <img src="${card.url}" alt="">
            </td>
            <td>
                <ul>
                    <li>NAME: ${card.name}</li>
                    <li>TYPE: ${card.type}</li>
                    <li>FACTION: ${card.faction}</li>
                    <li>DESCRIPTION ${card.discription}</li>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>
