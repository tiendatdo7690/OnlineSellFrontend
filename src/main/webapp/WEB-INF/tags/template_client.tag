<%@ tag language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="content" fragment="true" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
          crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top">
    <!-- Brand -->
    <a class="navbar-brand" href="#">
        <img src="${pageContext.request.contextPath }/resources/client/img/logo.png" alt="Logo" style="width: 40px;">
    </a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Trang chủ</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Sản phẩm
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Apple</a>
                    <a class="dropdown-item" href="#">Samsung</a>
                    <a class="dropdown-item" href="#">HTC</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Liên hệ</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Tài khoản
                </a>
                <div class="dropdown-menu">
                    <div class="container" style="width: 280px;">
                        <form method="POST" action="${pageContext.request.contextPath}/account/process-login">
                            <div class="form-group">
                                <label for="txtTenTK">Tên tài khoản:</label>
                                <input type="text" class="form-control" id="txtTenTK" name="username">
                            </div>
                            <div class="form-group">
                                <label for="txtMK">Mật khẩu:</label>
                                <input type="password" class="form-control" id="txtMK" name="pass">
                            </div>
                            <div class="custom-control custom-checkbox mb-2">
                                <input type="checkbox" class="custom-control-input" id="chkGhiNho" checked>
                                <label class="custom-control-label" for="chkGhiNho">Ghi nhớ tài khoản</label>
                            </div>
                            <button type="submit" class="btn btn-primary">Đăng nhập</button><a href="#"> Quên mật khẩu?</a>
                            <div class="dropdown-divider"></div>
                            Chưa có tài khoản? <a href="#">Đăng kí ngay</a>
                        </form>
                    </div>
                </div>
            </li>
        </ul>
        <a href="#" class="btn btn-success"><i class="fas fa-shopping-cart"></i> 2</a>
        <form class="form-inline" method="GET">
            <input class="form-control mr-sm-2" type="text" placeholder="Nhập từ khóa tìm kiếm">
            <button class="btn btn-success" type="submit">Tìm kiếm</button>
        </form>
    </div>
</nav>

<div style="margin-top:78px;"></div>

<jsp:invoke fragment="content"></jsp:invoke>
</body>

</html>