<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag import="org.springframework.util.StringUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pagedListHolder" required="true"
	type="org.springframework.beans.support.PagedListHolder"%>
<%@ attribute name="pagedLink" required="true" type="java.lang.String"%>


<c:if test="${pagedListHolder.pageCount > 1}">
	<div class="d-flex justify-content-center">
		<ul class="pagination align-content-center">
			<c:if test="${!pagedListHolder.firstPage}">
				<li class="page-item"><a class="page-link"
					href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() - 1))%>"><</a></li>
			</c:if>
			<c:if test="${pagedListHolder.firstLinkedPage > 0}">
				<li><a href="<%=StringUtils.replace(pagedLink, "~", "0")%>">1</a></li>
			</c:if>
			<c:if test="${pagedListHolder.firstLinkedPage > 1}">
				<li><span class="pagingDots">...</span>
				<li>
			</c:if>
			<c:forEach begin="${pagedListHolder.firstLinkedPage}"
				end="${pagedListHolder.lastLinkedPage}" var="i">
				<c:choose>
					<c:when test="${pagedListHolder.page == i}">
						<li class="page-item active"><a class="page-link" href="#">${i+1}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item" ><a class="page-link"
							href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if
				test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 2}">
				<li><span class="pagingDots">...</span></li>
			</c:if>
			<c:if
				test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 1}">
				<li class="page-item"><a class="page-link"
					href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPageCount() - 1))%>">${pagedListHolder.pageCount}</a></li>
			</c:if>
			<c:if test="${!pagedListHolder.lastPage}">
				<li class="page-item"><a class="page-link"
					href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() + 1))%>">></a></li>
			</c:if>
		</ul>
	</div>
</c:if>
