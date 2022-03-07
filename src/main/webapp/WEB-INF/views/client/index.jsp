<%--
  Created by IntelliJ IDEA.
  User: PCBD
  Date: 3/4/2022
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:template_client title = "Home">
    <jsp:attribute name="content">
        <img src="${pageContext.request.contextPath }/resources/client/img/logo.png" alt="Logo" style="width: 40px;">
    </jsp:attribute>
</mt:template_client>