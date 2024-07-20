<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/16/2024
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <mark>${message}</mark>
    <form action="/cookie" method="post">
        <table>
            <tr>
                <td>Usename:</td>
                <td><input name="username" value="${username}"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input name="password" type="password" value="${password}"></td>
            </tr>
        </table>
        <input type="checkbox" name="remember">Remember me?
        <hr>
        <button type="submit">Login</button>
    </form>
</body>
</html>
