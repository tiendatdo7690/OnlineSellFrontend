<%--
  Created by IntelliJ IDEA.
  User: PCBD
  Date: 3/21/2022
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<mt:template_client title = "Home">
    <jsp:attribute name="content">

        <div class="card-deck mb-2">
            <div class="card border-0">

                <div id="demoproduct" class="carousel slide" data-ride="carousel" >
                    <ul class="carousel-indicators">
                        <c:forEach begin="1" end="${product.images.size()}" var="i">
                            <c:if test="${i == 1}">
                                <li data-target="#demoproduct" data-slide-to="${i-1}" class="active" ></li>
                            </c:if>
                            <c:if test="${i != 1}">
                                <li data-target="#demoproduct" data-slide-to="${i-1}" ></li>
                            </c:if>
		            	</c:forEach>

                    </ul>

                    <div class="carousel-inner" >

                         <c:forEach begin="1" end="${product.images.size()}" var="i"  >
                            <c:if test="${i == 1}">
                                 <div class="carousel-item active" style="height: 300px">
                                     <img src="${product.images[i-1] }" style="height: 300px">
                                 </div>
                            </c:if>

                             <c:if test="${i != 1}">
                                 <div class="carousel-item" height="250px">
                                     <img src="${product.images[i-1] }" style="height: 300px">
                                 </div>
                            </c:if>
		            	</c:forEach>
                    </div>

                    <a class="carousel-control-prev" href="#demoproduct" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demoproduct" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>

                </div>

            </div>
            <div class="card border-0" style="height: 300px;">
                <s:form method="post" modelAttribute="productCart" action="${pageContext.request.contextPath}/client/addcart">
                    <s:hidden path="id"></s:hidden>
                    <s:hidden path="name"></s:hidden>
                    <s:hidden path="price"></s:hidden>
                    <h4 class="card-img-top d-flex justify-content-center">${product.name}</h4>
                    <div class="card-body">

                        <h5 class="text-danger">${product.price}₫</h5>
                        <p class="card-text">${product.description}</p>
                        <div class="input-group" >
                            <div class="input-group-prepend">
                                <button class="btn btn-outline-primary" type="button" id="buttonminus">-</button>
                            </div>

                            <s:input type="text" class="form-control" value="1" id="quantity" path="quantity"></s:input>

                            <div class="input-group-append">
                                <button class="btn btn-outline-primary" type="button" id="buttonadd">+</button>
                            </div>

                        </div>
                    </div>
                    <div class="card-footer bg-white border-0 d-flex justify-content-center">
                        <input type="submit"  class="btn btn-primary stretched-link" value="Thêm Giỏ Hàng">
                    </div>
                </s:form>
            </div>
        </div>



        <script>
            $(document).ready(function () {

                $('#buttonadd').click(function () {

                    var quantity = $('#quantity').val();
                    quantity++;
                    $('#quantity').val(quantity);

                })

                $('#buttonminus').click(function () {

                    var quantity = $('#quantity').val();
                    if(quantity > 1) {
                        quantity--;
                    }
                    $('#quantity').val(quantity);

                })
            })


        </script>
    </jsp:attribute>
</mt:template_client>