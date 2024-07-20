<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/15/2024
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>s
    <title>Upload Form</title>
</head>
<body>
<h1>Upload</h1>
<form action="/upload-file" method="post" enctype="multipart/form-data">
    Hình ảnh: <input type="file" name="photo"><br><br>
    Tài liệu: <input type="file" name="document"><br>
    <hr>
    <button type="submit">Upload</button>
</form>
</body>
</html>
