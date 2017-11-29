<%--
  Created by IntelliJ IDEA.
  User: IRedko
  Date: 29.11.2017
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login to Pro-Gwent</title>

</head>
<body>
<form action="/login/req" method="post">
    <table width="20%" align="center">

        <tr>
            <td colspan=2 style="text-align: center;"><span style="font-size: medium; "><b>Pro-Gwent Login Page</b></span>
            </td>
        </tr>

        <tr>
            <td>Username:</td>
            <td><input type="text" size=25 name="userid"></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><input type="Password" size=25 name="pwd"></td>
        </tr>

        <tr>
            <td ><input type="Reset" onclick="a" value="Reset" ></td>
            <td><input type="submit" value="Login"></td>
        </tr>

    </table>
</form>

</body>
</html>
