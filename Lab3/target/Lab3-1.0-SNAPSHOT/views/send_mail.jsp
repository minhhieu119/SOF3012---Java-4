<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/16/2024
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send email</title>
</head>
<body>
    <h1>${thongBao}</h1>
    <form action="/send-email" method="post">
        From: <input name="from"><br>
        Password: <input name="password" type="password">
        <hr>
        To: <input name="to"><br>
        Subject: <input name="subject"><br>
        Body:  <textarea name="body" cols="150" rows="20"></textarea>
        <hr>
        <button>Send</button>
    </form>
</body>
</html>
