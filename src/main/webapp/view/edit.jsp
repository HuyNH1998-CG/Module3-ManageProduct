<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
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
            <a href="/" class="btn btn-success">Quay Lại</a><br>
            <p>
                <c:if test="${message} != null">
                    <span class="message">${message}</span>
                </c:if>
            </p>
        </div>
        <div class="col-sm-8">
            <form method="post">
                <fieldset>
                    <legend>Thông tin sản phẩm</legend>
                    <table>
                        <tr>
                            <td>ID:</td>
                            <td><input type="text" name="id" id="id" value="${product.id}" readonly></td>
                        </tr>
                        <tr>
                            <td>Tên:</td>
                            <td><input type="text" name="name" id="name" value="${product.name}"></td>
                        </tr>
                        <tr>
                            <td>Giá:</td>
                            <td><input type="text" name="price" id="price" value="${product.price}"></td>
                        </tr>
                        <tr>
                            <td>Hình ảnh:</td>
                            <td><input type="text" name="picture" id="picture" value="${product.picture}"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button type="submit" class="btn btn-success">Sửa ngay</button>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>
