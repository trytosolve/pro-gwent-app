<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <c:forEach items="${cardList}" var="cards">
        <tr>
            <td>
                <img src="${cards.url}" alt="">
            </td>
            <td>
                <ul>
                    <li>NAME: ${cards.name}</li>
                    <li>TYPE: ${cards.type}</li>
                    <li>FACTION: ${cards.faction}</li>
                    <li>DESCRIPTION ${cards.discription}</li>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>