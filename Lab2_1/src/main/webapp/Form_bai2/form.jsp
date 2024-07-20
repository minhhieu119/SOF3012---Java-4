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
    <title>Lab 2 - Bài 2</title>
</head>
<body>
    <h1>Đăng kí</h1>
    <form action="/dang_ki" method="post">
        Tên đăng nhập: <input name="account" type="text" placeholder="Tên đăng nhập"/><br>
        Mật khẩu: <input name="password" type="password" placeholder="Mật khẩu"/><br>
        Giới tính: <input type="radio" name="gender" value="true">Nam
        <input type="radio" name="gender" value="false">Nữ<br>
        <input type="checkbox" name="maried"/>Đã có gia đình?<br>
        Quốc tịch: <select name="country">
        <option value="VN">Việt Nam</option>
        <option value="US">United States</option>
        <option value="JP">Nhật Bản</option>
                    </select><br>
        Ghi chú:<textarea name="description" rows="3" cols="30"></textarea>
        <hr>
        <button type="submit">Đăng kí</button>
    </form>
</body>
</html>
