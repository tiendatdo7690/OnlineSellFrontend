<%--
  Created by IntelliJ IDEA.
  User: PCBD
  Date: 3/23/2022
  Time: 1:40 PM
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
        <h3>List Order</h3>
        <c:if test="${isDelete == true}">
            <h4 class="text-success">Delete Success</h4>
        </c:if>
        <c:if test="${isDelete == false}">
            <h4 class="text-warning">Can't Delete</h4>
        </c:if>

          <jsp:useBean id="pagedListHolder" scope="request"
                       type="org.springframework.beans.support.PagedListHolder" />
            <c:url value="/" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

                 <c:forEach items="${pagedListHolder.pageList}" var="item">

                      <div class="card mb-3">
                          <c:if test="${item.success == true}">
                              <div class="card-header text-white bg-success">
                                  <h5>Order ${item.date}</h5>
                              </div>
                          </c:if>
                          <c:if test="${item.success == false}">
                              <div class="card-header text-white bg-warning">
                                  <h5>Order ${item.date}</h5>
                              </div>
                          </c:if>
                          <div class="card-body">
                              <h5 class="card-title">${item.nameProduct}</h5>
                              <p class="card-text">${item.address}</p>
                              <div class="inline-flex">
                                  <a href="${pageContext.request.contextPath}/client/deliveryprocess/${item.id}" class="btn btn-primary">Detail</a>
                                  <a href="${pageContext.request.contextPath}/client/deleteorder/${item.id}" class="btn btn-danger">Delete</a>
                              </div>
                          </div>
                      </div>

			</c:forEach>
         <mt:paging pagedListHolder="${pagedListHolder}"
                    pagedLink="${pagedLink}" />
    </jsp:attribute>
</mt:template_client>