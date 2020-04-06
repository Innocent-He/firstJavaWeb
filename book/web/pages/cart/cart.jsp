<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a#money").click(function () {
				return confirm("确认提交订单？")
			})
			$("a.delete").click(function () {
				return confirm("确认要删除"+$(this).parent().parent().find("td:first").text()+"吗？")
			})
			$("a#delete").click(function () {
				return confirm("确认要清空购物车吗")
			})
			$(".input").change(function () {
				if (confirm("确认修改【"+$(this).parent().parent().find("td:first").text()+"】数量为"+this.value+"吗？")){
					var id=$(this).attr("bookid");
					return location.href="/book/cartServlet?action=alterCount&id="+id+"&count="+this.value;
				}else{
					this.value(this.defaultValue)
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

		<c:if test="${empty sessionScope.cart.items}">

			<tr>
				<td colspan="5">亲，当前购物车为空</td>

			</tr>
			<tr>
				<td colspan="5"><a href="index.jsp">添加商品</a></td>
			</tr>
		</c:if>
		<c:if test="${not empty sessionScope.cart.items}">


				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td><input type="text" class="input" value="${entry.value.count}" bookid="${entry.value.id}"></td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a href="cartServlet?action=delete&id=${entry.value.id}" class="delete" }>删除</a></td>
					</tr>
				</c:forEach>
			</table>
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalCountPrice}</span>元</span>
			<span class="cart_span"><a href="cartServlet?action=clear" id="delete">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=submit" id="money">去结账</a></span>
		</div>
		</c:if>
	</div>

	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>