<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 2020/3/9
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临丹怡零食铺</span>
    <a href="orderServlet?action=showMyOrder">我的订单</a>
    <a href="index.jsp">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>