<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<div class="container mt-3">
    <h1>Quản lý người dùng</h1>
    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Password</th>
            <th>Email</th>
            <th>Fullname</th>
            <th>Admin</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${list}" varStatus="i">
            <tr>
                <td>${user.id}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.fullname}</td>
                <td>${user.admin}</td>
                <td class="d-flex justify-content-center">
                    <a href="/user/view-update?viTri=${i.index}" class="btn btn-warning">Update</a>
                    <a href="/user/delete?viTri=${i.index}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button class="btn btn-outline-primary" type="submit"><a href="/user/view-add">Add User</a></button>
</div>