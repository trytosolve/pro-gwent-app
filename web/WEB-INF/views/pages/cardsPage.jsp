<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="${pageContext.request.contextPath}/cards" modelAttribute="searchForm" method="post">
    <table align="left">

    <tr>
        <td>Search:</td>
        <td><form:input path="searchParam"/></td>
        <td><span class="error"><form:errors path="searchParam"/></span></td>
        <td colspan="3"><input type="submit" value="Ok"/></td>
    </tr>

    <%--<td>--%>
        <%--<input type="checkbox" name="topping" value="choc">Chocolate</input><br/>--%>
        <%--<input type="checkbox" name="topping" value="cane">Candy Cane</input><br/>--%>
        <%--<input type="checkbox" name="topping" value="flower">Flower</input><br/>--%>
    <%--</td>--%>
</form:form>

<table>
    <c:forEach items="${cardList}" var="cards">
        <tr>
            <td>
                <img src="${cards.url}" alt="">
            </td>
            <td>
                <ul>
                    <li>NAME: ${cards.name}</li> <!-- TODO все таки елемент это card а не cards -->
                    <li>TYPE: ${cards.type}</li>
                    <li>FACTION: ${cards.faction}</li>
                    <li>DESCRIPTION ${cards.discription}</li>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>