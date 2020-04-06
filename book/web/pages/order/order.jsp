<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>

	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
	<script type="text/javascript">
		$(function () {
			$("a#receive").click(function () {
				return confirm("确认签收？")
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">

		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>订单号</td>
				<td>查看详情</td>
				<td>签收</td>
			</tr>
			<c:forEach items="${sessionScope.orders}" var="order">
				<tr>
					<td>${order.create_time}</td>
					<td>${order.price}</td>
					<td>
						<c:choose>
							<c:when test="${order.status==0}">
								未发货
							</c:when>
							<c:when test="${order.status==1}">
								已发货
							</c:when>
							<c:when test="${order.status==2}">
								已签收
							</c:when>
						</c:choose>
					</td>
					<td>${order.order_id}</td>
					<td><a href="/book/orderServlet?action=findDetail&id=${order.order_id}">查看详情</a></td>
					<td><a href="/book/orderServlet?action=receiveOrder&id=${order.order_id}" id="receive" >签收</a></td>
				</tr>

			</c:forEach>
		</table>
		
	
	</div>
	
	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>