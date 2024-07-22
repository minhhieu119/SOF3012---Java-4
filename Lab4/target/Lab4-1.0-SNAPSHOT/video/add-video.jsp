<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/22/2024
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container mt-3">
    <h1>Thêm mới video</h1>
    <form action="/video/add" method="post">
        <div class="mb-3">
            <label class="form-label">ID</label>
            <input class="form-control" type="text" name="id"><span class="text-danger">${idMess}</span>
        </div>
        <div class="mb-3">
            <label class="form-label">Title</label>
            <input class="form-control" type="text" name="title"><span class="text-danger">${titleMess}</span>
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea class="form-control" type="text" name="decription"></textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">Active</label>
            <input class="form-check-label" type="checkbox" name="active">
        </div>
        <div class="mb-3">
            <label class="form-label">Poster</label>
            <input class="form-control" type="text" name="poster"><span class="text-danger">${posterMess}</span>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
