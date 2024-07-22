<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container mt-3">
    <h1>Quản lý video</h1>
    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr><th>STT</th>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Active</th>
            <th>Poster</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="v" items="${list}" varStatus="i">
            <tr>
                <td class="align-middle text-center">${i.index + 1}</td>
                <td class="align-middle text-center">${v.id}</td>
                <td class="align-middle text-center">${v.title}</td>
                <td class="align-middle text-center">${v.description}</td>
                <td class="align-middle text-center">${v.active ? "Yes" : "No"}</td>
                <td><img src="${v.poster}" width="350px" height="200px" class="rounded"> </td>
                <td class="align-middle text-center">
                    <a href="/video/view-update?viTri=${i.index}" class="btn btn-warning">Update</a>
                    <a href="/video/delete?viTri=${i.index}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button class="btn btn-outline-primary" type="submit"><a href="/video/view-add">New movie</a></button>
</div>
</body>
</html>
