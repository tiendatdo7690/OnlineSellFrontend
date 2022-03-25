<%--
  Created by IntelliJ IDEA.
  User: PCBD
  Date: 3/4/2022
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<mt:template_client title = "Home">
    <jsp:attribute name="content">

        <h4>${category}</h4>
        <c:if test="${pagedListHolder != null}">
            <jsp:useBean id="pagedListHolder" scope="request"
                         type="org.springframework.beans.support.PagedListHolder" />
                <c:url value="/" var="pagedLink">
                <c:param name="p" value="~" />
            </c:url>

                    <div class= "row">
                     <c:forEach items="${pagedListHolder.pageList}" var="item">

                         <div class ="col-6 col-sm-4 col-md-3 p-2">
                             <div class="card h-100 border-0">

                                    <img class="card-img-top" src="${item.urlFileAvatar }" height="300px" alt="${item.name}">

                                 <div class="card-body">
                                     <h4 class="card-title">${item.name}</h4>
                                     <h5 class="text-danger">${item.price}₫</h5>
                                     <p class="card-text">${item.description} <b>1 K.mãi</b>
                                         khác</p>
                                 </div>
                                 <div class="card-footer bg-white border-0">
                                     <a href="${pageContext.request.contextPath}/product/${item.id}"
                                        class="btn btn-primary stretched-link"><i class="fas fa-shopping-cart"></i> Mua ngay
                                     </a>
                                 </div>
                             </div>
                         </div>

                </c:forEach>
                    </div>
             <mt:paging pagedListHolder="${pagedListHolder}"
                        pagedLink="${pagedLink}" />
        </c:if>
    </jsp:attribute>
</mt:template_client>