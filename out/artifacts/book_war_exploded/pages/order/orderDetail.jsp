<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 2020/3/13
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
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
            <td>订单编号</td>
        </tr>
        <c:forEach items="${sessionScope.orderItems}" var="detail">
            <tr>
                <td>${detail.name}</td>
                <td>${detail.count}</td>
                <td>${detail.price}</td>
                <td>${detail.total_price}</td>
                <td>${detail.order_id}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>
