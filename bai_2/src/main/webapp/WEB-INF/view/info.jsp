<%--
  Created by IntelliJ IDEA.
  User: anhda
  Date: 6/15/2023
  Time: 2:46 PM
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

<h3>Thông tin chi tiết</h3>

<a href="/player">Quay về trang chính</a>

<table class="table table-striped table-inverse table-responsive">
    <tr>
        <td>Số thứ tự:</td>
        <td>${player.id}</td>
    </tr>

    <tr>
        <td>Tên:</td>
        <td>${player.name}</td>
    </tr>

    <tr>
        <td>Ngày sinh:</td>
        <td> ${player.dateOfBirth}</td>
    </tr>

    <tr>
        <td>Kinh nghiệm:</td>
        <td> ${player.experience}</td>
    </tr>

    <tr>
        <td>Vị trí:</td>
        <td> ${player.location}</td>
    </tr>

    <tr>
        <td>Hình ảnh:</td>
        <td><img src="${player.image}" alt="" width="100" height="100"></td>
    </tr>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>