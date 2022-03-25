<%--
  Created by IntelliJ IDEA.
  User: PCBD
  Date: 3/25/2022
  Time: 10:13 AM
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

                 <c:forEach items="${processes}" var="item">

                      <div class="card mb-3">
                          <div class="card-header text-dark ">
                              <h5>Order ${item.date}</h5>
                          </div>
                          <div class="card-body">
                              <p class="card-text">${item.name}</p>
                          </div>
                      </div>

			</c:forEach>

    </jsp:attribute>
</mt:template_client>
