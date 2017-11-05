<%--
  Created by IntelliJ IDEA.
  User: IRedko
  Date: 03.11.2017
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gwent news</title>
    <style>
        .center {
            text-align: center;
        }
    </style>
</head>

<h1 class=center>Gwent news</h1>
<div></div>
<!--
TODO  здесь должна быть итерация по новостям. Гугли JSP JSTL forEach.
вот тут нормальное описание более-менее
https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm
Обрати внимание, что используется дополнительная библиотека тегов JSTL (которую мы изначально добавили в наш pom.xml.
Для того чтобы использовать доп. библиотеки тегов в твоей JSP нужно добавить import на нее (аналогично как с классами в java)
В примере по ссылке есть импорт. Не забудь его написать
-->
<div>
    ${date}
    <a href="${path}">${name}</a>
</div>

<div>
    ${discription}
</div>

<div>
    ${date1}
    <a href="${path1}">${name1}</a>
</div>

<div>
    ${discription1}
</div>
<div>
    ${text}
</div>

</body>
</html>
