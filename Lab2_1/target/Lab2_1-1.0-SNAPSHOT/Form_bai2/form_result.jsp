<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/9/2024
  Time: 8:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Lab 2 - Bài 2</title>
</head>
<body>
    <h1>Thông tin đăng kí</h1>
    <ul>
        <li>Tên đăng nhập: ${param.account}</li>
        <li>Mật khẩu: ${param.password}</li>
        <li>Giới tính: ${param.gender}</li>
        <li>Tình trạng hôn nhân: ${param.maried}</li>
        <li>Quốc tịch: ${param.country}</li>
        <li>Ghi chú: ${param.description}</li>
    </ul>
</body>
</html>
