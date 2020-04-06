<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a#send").click(function () {
				return confirm("确认发货？")
			})
		})
	</script>
</head>
<body>

<%@include file="/pages/common/manager.jsp"%>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>状态</td>
				<td>发货</td>

				
			</tr>		
			<c:forEach items="${sessionScope.allOrders}" var="order">
				<tr>
					<td>${order.create_time}</td>
					<td>${order.price}</td>
					<td><a href="orderServlet?action=findDetail&id=${order.order_id}">详情</a></td>
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
					<td><a href="/book/orderServlet?action=sendOrder&id=${order.order_id}" id="send">发货</a> </td>

				</tr>
			</c:forEach>
		</table>
	</div>

	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>