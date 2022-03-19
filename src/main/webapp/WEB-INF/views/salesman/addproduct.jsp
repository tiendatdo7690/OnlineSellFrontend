<%--
  Created by IntelliJ IDEA.
  User: WIN10
  Date: 16-Mar-22
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<mt:template_salesman title = "Home">
    <jsp:attribute name="content">
<h3>Add Product</h3>

         <s:form method="post" modelAttribute="product" action="${pageContext.request.contextPath}/salesman/saveproduct">

            <table>
                <tr>
                    <td>Name</td>
                    <td>
                        <s:input path="name"/>
                    </td>
                </tr>

                <tr>
                    <td>Description</td>
                    <td>
                        <s:textarea path="description" cols="20" rows="5"/>
                    </td>
                </tr>

                <tr>
                    <td>InventoryNumber</td>
                    <td>
                        <s:input path="inventoryNumber"/>
                    </td>
                </tr>

                <tr>
                    <td>Date</td>
                    <td>
                        <s:input path="dateSell" id ="datepicker"/>
                    </td>
                </tr>

                <tr>
                    <td>Name</td>
                    <td>
                        <s:checkbox path="status"/>
                    </td>
                </tr>

                <tr>
                    <td>Category</td>
                    <td>
                        <s:select path="idCategory" items="${categories }" itemLabel="name" itemValue="id"/>
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
</mt:template_salesman>
