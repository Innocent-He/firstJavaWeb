<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>零食管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

	$(function(){
		<!--这里不可以用id绑定器？-->
		$("a.delete").click(function(){
			<!--这里加return是因为如果取消的话返回false-->
			return confirm("确认要删除["+$(this).parent().parent().find("td:first").text()+"]吗？");
		});
	});
	</script>


</head>
<body>

<%@include file="/pages/common/manager.jsp"%>
	
	<div id="main">
		<table>

			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>厂家</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td> <a href="manager/bookServlet?action=getbook&id=${book.id}">修改</a></td>
				<td> <a href="manager/bookServlet?action=delete&id=${book.id}" class="delete">删除</a></td>

			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加零食</a></td>
			</tr>
		</table>
			<div id="page_nav">
				<c:if test="${requestScope.page.pageNo>1}">
					<a href="${requestScope.page.url}&pageNo=1">首页</a>
					<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>;
				</c:if>

				<c:choose>
					<c:when test="${requestScope.page.pagetotal<=5}">
							<c:set var="begin" value="${1}"></c:set>
							<c:set var="end" value="${requestScope.page.pagetotal}"></c:set>
					</c:when>
					<c:when test="${requestScope.page.pagetotal>5}">
							<c:choose>
								<c:when test="${requestScope.page.pageNo<=3}">
									<c:set var="begin" value="1"></c:set>
									<c:set var="end" value="5"></c:set>
								</c:when>
								<c:when test="${requestScope.page.pageNo>requestScope.page.pagetoal-3}">
									<c:set var="begin" value="${requestScope.page.pagetotal-4}"></c:set>
									<c:set var="end" value="${requestScope.page.pagetotal}"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
									<c:set var="end" value="${requestScope.page.pageNo+2}"></c:set>
								</c:otherwise>
							</c:choose>
					</c:when>
				</c:choose>

				<c:forEach begin="${begin}" end="${end}" var="i">
					<c:if test="${i == requestScope.page.pageNo}">
						【${i}】
					</c:if>
					<c:if test="${i != requestScope.page.pageNo}">
						<a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
					</c:if>
				</c:forEach>

				<c:if test="${requestScope.page.pageNo<requestScope.page.pagetotal}">
						<a href="${requestScope.page.url}&pageNo=${requestScope.page.pagetotal}">尾页</a>
						<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				</c:if>
				共${requestScope.page.bookTotal}条记录
				<form href="manager/bookServlet" method="get">
					<input type="hidden" name="action" value="page"/>
					到第<input type="text" name="pageNo"/>页
					<input type="submit" value="确定"/>
				</form>

			</div>

	</div>
	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>