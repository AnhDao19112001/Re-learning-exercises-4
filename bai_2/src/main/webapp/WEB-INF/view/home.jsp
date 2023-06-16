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
        <th>Vị trí</th>
        <th>Ảnh</th>
        <th>Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${player}" var="football">
        <tr>
            <td>${football.id}</td>
            <td><a href="info/${football.id}">${football.name}</a></td>
            <td>${football.location}</td>
            <td><img src="${football.image}" alt="" width="100" height="100"></td>
            <td>
                <button attr="onclick=|deletePlayer('${football.id}', '${football.name}')|"
                        class="btn btn-danger btn-outline-secondary btn-sm" data-bs-toggle="modal"
                        data-bs-target="#deletePlayer" style="padding: 0.47rem 1.9rem">
                    <span class="fa-solid fa-person-circle-minus text-light h6 m-auto px-2">Xóa</span>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="deletePlayer" tabindex="-1" aria-labelledby="exampleModalLabel1"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content modalCSS">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel1">Bạn có chắc chắn muốn xóa?</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <form action="/delete">

                <div>
                    Bạn có muốn xóa cầu thủ?
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-danger" value="idDelete">Xóa</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function deletePlayer(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
        debugger
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>