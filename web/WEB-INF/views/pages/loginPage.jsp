<form action="${pageContext.request.contextPath}/loginPage/login" method="post">
    <table width="20%" align="center">
        <tr>
            <td colspan=2 style="text-align: center;"><span
                    style="font-size: medium; "><b>Pro-Gwent Login Page</b></span>
            </td>
        </tr>

        <tr>
            <td>Username:</td>
            <td><input type="text" size=25 name="login"></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><input type="Password" size=25 name="pwd"></td>
        </tr>

        <tr>
            <td><input type="Reset" onclick="a" value="Reset"></td>
            <td><input type="submit" value="Login"></td>

        </tr>
        <tr>
            <td></td>
            <td><b><a href="/loginPage/createAccountPage">New account</a></b></td>
        </tr>
    </table>
</form>