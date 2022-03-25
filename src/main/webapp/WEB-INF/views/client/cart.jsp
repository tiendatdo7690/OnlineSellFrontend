<%--
  Created by IntelliJ IDEA.
  User: PCBD
  Date: 3/22/2022
  Time: 10:58 PM
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

        <h3>Cart</h3>
        <s:form method="post" modelAttribute="infoOrder" action="${pageContext.request.contextPath}/client/order">
            <table class="table" id="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="0"></c:set>
                <c:forEach begin="1" end="${sessionScope.cart.size()}" var="i"  >
                    <tr>
                        <th scope="row">${i}</th>
                        <td>${sessionScope.cart[i-1].name}</td>
                        <td>${sessionScope.cart[i-1].price}</td>
                        <td>${sessionScope.cart[i-1].quantity}</td>
                        <td>${sessionScope.cart[i-1].quantity * sessionScope.cart[i-1].price}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/client/deleteproductcart/${sessionScope.cart[i-1].id}" class="btn btn-danger" >Delete</a>
                        </td>
                        <c:set var="total" value="${total + (sessionScope.cart[i-1].quantity * sessionScope.cart[i-1].price)}"></c:set>
                    </tr>
                </c:forEach>
                </tbody>

                <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Total Money</td>
                    <th scope="row" > ${total}</th>
                </tr>
                </tfoot>
            </table>

            <h5>Select Address</h5>
            <c:forEach items="${addresses}" var="address">

                <div class="form-check">
                    <label class="form-check-label">
                        <s:radiobutton path="idAddress" cssClass="form-check-input" value="${address.id}" checked = "true" /> ${address.address}
                    </label>
                </div>
            </c:forEach>

            <s:hidden path="idCustomer"></s:hidden>
            <div class="d-flex justify-content-center">
                <input type="submit" class="btn btn-primary" value="Order" >
            </div>

        </s:form>


    </jsp:attribute>
</mt:template_client>
