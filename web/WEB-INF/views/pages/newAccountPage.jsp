<form action="${pageContext.request.contextPath}/loginPage/createAccount" method="post">
    <table width="20%" align="center">
        <tr>
            <td colspan=2 style="text-align: center;"><span
                    style="font-size: medium; "><b>Pro-Gwent Login Page</b></span>
            </td>
        </tr>

        <tr>
            <td>Username:</td>
            <td><input type="text" size=25 name="userid"></td>
        </tr>


        <tr>
            <td>Email:</td>
            <td><input type="Email" size=25 name="email"></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><input type="Password" size=25 name="pwd"></td>
        </tr>

        <tr>
            <td><input type="Reset" onclick="a" value="Reset"></td>
            <td><input type="submit" value="Create"></td>

        </tr>
    </table>
</form>
