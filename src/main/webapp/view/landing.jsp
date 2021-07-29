<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
  <h1>Điện máy không màu</h1>
</div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <h1 class="navbar-brand">Menu</h1>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
    </ul>
  </div>
</nav>
<div class="container" style="margin-top: 30px;">
  <div class="row">
    <div class="col-sm-4">
      <a href="/?action=create" class="btn btn-success">Tạo mới</a><br>
      <p>Nhập tên sản phẩm để tìm kiếm</p>
      <form action="/?action=search" method="post">
        <input type="text" name="name" placeholder="Product name">
        <button type="submit" class="btn btn-success">Tìm kiếm</button>
      </form>
    </div>
    <div class="col-sm-8">
      <table border="1">
        <tr>
          <td>ID</td>
          <td>Tên</td>
          <td>Giá</td>
          <td>Hình ảnh</td>
          <td>Sửa</td>
          <td>Xóa</td>
        </tr>
        <c:forEach items="${product}" var="prd">
          <tr>
            <td>${prd.id}</td>
            <td>${prd.name}</td>
            <td>${prd.price}</td>
            <td><a href="/?action=view&id=${prd.id}"><img src="${prd.picture}" style="width: 400px;height: 300px"></a></td>
            <td><a href="/?action=edit&id=${prd.id}" class="btn btn-warning">Sửa</a></td>
            <td><a href="/?action=delete&id=${prd.id}" class="btn btn-danger">Xóa</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
</body>
</html>
