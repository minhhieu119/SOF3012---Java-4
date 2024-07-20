<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/15/2024
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin nhân viên</title>
</head>
<body>
    <h1>Thông tin nhân viên</h1>
    <ul>
        <li>Họ và tên: ${bean.fullname}</li>
        <li>Ngày sinh: ${bean.birthday}</li>
        <li>Giới tính: ${gender}</li>
        <li>Quốc tịch: ${country}</li>
        <li>TT hôn nhân: ${maried}</li>
        <li>Sở thích: ${hobbies}</li>
        <li>Ghi chú: ${bean.note}</li>
    </ul>
</body>
</html>
