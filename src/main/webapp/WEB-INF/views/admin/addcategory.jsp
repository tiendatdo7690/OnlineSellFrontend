<%--
  Created by IntelliJ IDEA.
  User: PCBD
  Date: 3/19/2022
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<mt:template_admin title = "Home">
    <jsp:attribute name="content">
<h3>Add Category</h3>

        <s:form method="post" modelAttribute="category" action="${pageContext.request.contextPath}/admin/savecategory">

            <table>
                <tr>
                    <td>Name</td>
                    <td>
                        <s:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </s:form>
    </jsp:attribute>

</mt:template_admin>

