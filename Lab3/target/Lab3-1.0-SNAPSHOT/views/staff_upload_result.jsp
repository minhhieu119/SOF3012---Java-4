<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/16/2024
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff Upload Result</title>
</head>
<body>
<h1>Thông tin nhân viên</h1>
<ul>
    <li>Họ và tên: ${bean.fullname}</li>
    <li>Hình ảnh: ${bean.photo}<br>
        <img src="/files/${bean.photo}" height="100">
    </li>
    <li>Ngày sinh: ${bean.birthday}</li>
    <li>Giới tính: ${gender}</li>
    <li>Quốc tịch: ${country}</li>
    <li>TT hôn nhân: ${maried}</li>
    <li>Sở thích: ${hobbies}</li>
    <li>Ghi chú: ${bean.note}</li>
</ul>
</body>
</html>
