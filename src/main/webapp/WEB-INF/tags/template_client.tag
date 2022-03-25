<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Sản phẩm
                </a>
                <div class="dropdown-menu">
                    <c:forEach items="${categories}" var="item">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/home?category=${item.name}">${item.name}</a>
                    </c:forEach>

                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Liên hệ</a>
            </li>
            <li class="nav-item dropdown">
                <c:if test="${pageContext.request.userPrincipal == null}">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Tài khoản
                        </a>
                        <div class="dropdown-menu">

                        <div class="container" style="width: 280px;">
                            <form method="POST" action="${pageContext.request.contextPath}/account/process-login">
                                <div class="form-group">
                                    <label for="txtTenTK">User Name:</label>
                                    <input type="text" class="form-control" id="txtTenTK" name="username">
                                </div>
                                <div class="form-group">
                                    <label for="txtMK">Pass:</label>
                                    <input type="password" class="form-control" id="txtMK" name="pass">
                                </div>
                                <button type="submit" class="btn btn-primary">Login</button><a href="#"> Forget Password?</a>
                                <div class="dropdown-divider"></div>
                                <a href="#"Register</a>
                            </form>
                        </div>
                    </c:if>

                    <c:if test="${pageContext.request.userPrincipal != null}">
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Welcome ${pageContext.request.userPrincipal.name}
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/client/listorder">Order History</a>
                            </div>


                    </c:if>

            </li>
        </ul>
        <a href="${pageContext.request.contextPath}/client/cart" class="btn btn-success"><i class="fas fa-shopping-cart"></i> ${sessionScope.countCart}</a>
        <form class="form-inline" method="post" action="${pageContext.request.contextPath}/home/search">
            <input class="form-control mr-sm-2" type="text" placeholder="Insert Key" name="keySearch">
            <button class="btn btn-success" type="submit">Find</button>
        </form>
    </div>
</nav>

<div style="margin-top:78px;"></div>

<div class="container mb-2">
    <div class="row">
        <div class="col-md-12">
            <div id="demo" class="carousel slide" data-ride="carousel">
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                    <li data-target="#demo" data-slide-to="4"></li>
                    <li data-target="#demo" data-slide-to="5"></li>
                </ul>

                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="${pageContext.request.contextPath }/resources/client/img/slide0.png">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath }/resources/client/img/slide1.png">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath }/resources/client/img/slide2.png">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath }/resources/client/img/slide3.png">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath }/resources/client/img/slide4.png">
                    </div>
                </div>

                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-3 mb-2">
            <h5>Danh mục sản phẩm</h5>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">Hàng mới về!</a>
                </li>
                <c:forEach items="${categories}" var="category">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/home?category=${category.name}">${category.name}</a>
                    </li>

                </c:forEach>

            </ul>
        </div>
        <div class="col-md-9">
            <jsp:invoke fragment="content"></jsp:invoke>

        </div>
    </div>
</div>

</body>

</html>