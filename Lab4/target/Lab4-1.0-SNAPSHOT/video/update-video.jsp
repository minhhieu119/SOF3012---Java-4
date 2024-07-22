<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/22/2024
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Sửa video</title>
</head>
<body>
<div class="container mt-3">
    <h1>Sửa video</h1>
    <form action="/video/update?id=${video.id}" method="post">
        <div class="mb-3">
            <label class="form-label">Title</label>
            <input class="form-control" type="text" name="title" value="${video.title}"><span class="text-danger">${titleMess}</span>
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea class="form-control" type="text" name="decription">${video.description}</textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">Active</label>
            <input class="form-check-label" type="checkbox" name="active" ${video.active ? "checked" : ""}>
        </div>
        <div class="mb-3">
            <label class="form-label">Poster</label>
            <input class="form-control" type="text" name="poster" value="${video.poster}"><span class="text-danger">${posterMess}</span>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
