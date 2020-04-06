<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%@include file="/pages/common/head.jsp"%>
	<Script type="text/javascript">
		$(function () {
			$("button.botn").click(function () {
				var bookid=$(this).attr("bookId");
				//location.href="http://localhost:8888/book/cartServlet?action=addItem&id="+bookid;
				$.getJSON("http://localhost:8888/book/cartServlet?","action=ajaxAddItem&id="+bookid,function (data) {
					$("#lastname").text(data.lastTime);
					$("#test").text("您的购物车中有"+data.count+"件商品");
				})
			})

		})
	</Script>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">丹怡零食铺</span>
			<div>
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=loginout">注销</a>&nbsp;
					<a href="pages/cart/cart.jsp">购物车</a>

				</c:if>
				<c:if test="${sessionScope.user.id==1}">
					<a href="pages/manager/manager.jsp">后台管理</a>
				</c:if>



			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice"/>
					价格：<input id="min" type="text" name="small" value="${param.small}"/> 元 -
						<input id="max" type="text" name="big" value="${param.big}"/> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${ empty sessionScope.cart.items}">
				<span ID="test"></span>
				<div>
					购物车为空
				</div>
				</c:if>
				<c:if test="${not empty sessionScope.cart.items}">
					<span id="count">您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
					<div>
						您刚刚将<span style="color: red" id="lastname">${sessionScope.lastName}</span>加入到了购物车中
					</div>
				</c:if>

			</div>
			<c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">名称:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">厂家:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button bookId="${book.id}"  class="botn">加入购物车 </button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>

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
				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pagetotal}&small=${param.small}">尾页</a>
				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
			</c:if>
			共${requestScope.page.bookTotal}条记录
			<form href="client/bookServlet" method="get">
				<input type="hidden" name="action" value="page"/>
				到第<input type="text" name="pageNo"/>页
				<input type="submit" value="确定"/>
			</form>

		</div>
	
	</div>
	
	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>