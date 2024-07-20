<%--
  Created by IntelliJ IDEA.
  User: MSII
  Date: 7/20/2024
  Time: 8:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Add User</title>
</head>
<body>
<div class="container mt-3">
    <h1>Add User Detail</h1>
    <h3 class="text-danger">${message}</h3>
    <form action="/user/add" method="post">
        <div class="mb-3">
            <label class="form-label">ID</label>
            <input class="form-control" type="text" name="id">
        </div>
        <div class="mb-3">
            <label class="form-label">Password</label>
            <input class="form-control" type="password" name="password">
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input class="form-control" type="text" name="email">
        </div>
        <div class="mb-3">
            <label class="form-label">Fullname</label>
            <input class="form-control" type="text" name="fullname">
        </div>
        <div class="mb-3">
            <label class="form-label">Admin</label>
            <input class="form-check-label" type="checkbox" name="admin">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
