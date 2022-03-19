
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ tag language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="content" fragment="true" %>

<mt:template_manager title = "Home">
     <jsp:attribute name="menu">

        <li class="nav-item">
            <a href="#" class="nav-link">
                <p>
                    Category
                    <i class="fas fa-angle-left right"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/admin/addcategory" class="nav-link">
                        <i class="fa fa-plus nav-icon"></i>
                        <p>Add Category</p>
                    </a>
                </li>

            </ul>
        </li>

    </jsp:attribute>

    <jsp:attribute name="content">

        <jsp:invoke fragment="content"></jsp:invoke>
    </jsp:attribute>
</mt:template_manager>