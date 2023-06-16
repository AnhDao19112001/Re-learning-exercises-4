<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anhda
  Date: 6/12/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<h2 class="text-center">Danh sách cầu thủ bóng đá</h2>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Số thứ tự</th>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Kinh nghiệm</th>
        <th>Vị trí</th>
        <th>Ảnh</th>
        <th>Thông tin chi tiết</th>
        <th>Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${player}" var="football">
        <tr>
<%--            <td>${football.id}</td>--%>
            <td><a href="/player/info?id=${football.id}">${football.id}</a></td>
            <td>${football.name}</td>
            <td>${football.dateOfBirth}</td>
            <td>${football.experience}</td>
            <td>${football.location}</td>
            <td><img src="${football.image}" alt="" width="100" height="100"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>