<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/8/2024
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tính chu vi tam giác</title>
</head>
<body>
    <h1>TAM GIÁC</h1>
    <form action="Lab2_Bai1Servlet" method="post">
        <input name="a" placeholder="Cạnh a"><br>
        <input name="b" placeholder="Cạnh b"><br>
        <input name="c" placeholder="Cạnh c"><br>
        <hr>
        <button type="submit" formaction="/dien_tich">Tính diện tích</button>
        <button type="submit" formaction="/chu_vi">Tính chu vi</button>
        <br>
        <h2>${message}</h2>
    </form>
</body>
</html>
