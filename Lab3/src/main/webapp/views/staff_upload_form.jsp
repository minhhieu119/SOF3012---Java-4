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
    <title>Staff Upload Form</title>
</head>
<body>
<form action="/staff-upload" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Họ và tên:</td>
            <td><input type="text" name="fullname"></td>
        </tr>
        <tr>
            <td>Hình ảnh:</td>
            <td><input type="file" name="photo"></td>
        </tr>
        <tr>
            <td>Ngày sinh:</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>Quốc tịch:</td>
            <td>
                <select name="country">
                    <option value="VI">Việt Nam</option>
                    <option value="US">Mỹ</option>
                    <option value="JP">Nhật Bản</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Giới tính:</td>
            <td>
                <input type="radio" name="gender" value="true">Nam
                <input type="radio" name="gender" value="false">Nữ
            </td>
        </tr>
        <tr>
            <td>TT Hôn nhân:</td>
            <td><input type="checkbox" name="maried">Đã có gia đình</td>
        </tr>
        <tr>
            <td>Sở thích:</td>
            <td>
                <input type="checkbox" name="hobies" value="R">Đọc sách
                <input type="checkbox" name="hobies" value="T">Du lịch
                <input type="checkbox" name="hobies" value="M">Âm nhạc
                <input type="checkbox" name="hobies" value="O">Khác
            </td>
        </tr>
        <tr>
            <td>Ghi chú:</td>
            <td>
                <textarea name="note" cols="30" rows="3"></textarea>
            </td>
        </tr>
    </table>
    <hr>
    <button type="submit">Thêm mới</button>
</form>
</body>
</html>
