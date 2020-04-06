<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>零食铺会员注册页面</title>
		<%@include file="/pages/common/head.jsp"%>
		<style type="text/css">
			.login_form{
				height:420px;
					margin-top: 25px;
			}
			span.redDiv{
				color: red;
				font-size: 10px;
			}
			span.greeDiv{
				color: darkgreen;
				font-size: 10px;
			}

		</style>
		<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
		<script type="text/javascript">

			$(function () {
				var userRegex=/^[a-zA-Z0-9_-]{4,16}$/
				var passRegex=/^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
				var emailRegex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
				$("#username").blur(function(){
					if(!userRegex.test(this.value)){
						$("#i1").addClass("redDiv").text("格式错误")
					}else{
						var username=this.value
						$.getJSON("http://localhost:8888/book/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
							if (data.existsUsername){
								$("#i1").addClass("greeDiv").text("已存在")
							}else{
								$("#i1").addClass("greeDiv").text("正确")
							}
						})


					}

				});
				$("#password").blur(function(){
					if(!passRegex.test(this.value)){
						$("#i2").addClass("redDiv").text("格式错误")
					}else{
						$("#i2").addClass("greeDiv").text("正确")
					}
				});
				$("#repwd").blur(function(){
					if($("#password").val()!=this.value){
						$("#i3").addClass("redDiv").text("格式错误")
					}else{
						$("#i3").addClass("greeDiv").text("正确")
					}
				});
				$("#email").blur(function(){
					if(!emailRegex.test(this.value)){
						$("#i4").addClass("redDiv").text("格式错误")
					}else{
						$("#i4").addClass("greeDiv").text("正确")
					}
				});

				$("#sub_btn").click(function(){
					if($("#i1").text()=="正确"&$("#i2").text()=="正确"&$("#i3").text()=="正确"&$("#i4").text()=="正确"){
						alert("注册成功")
						
					}else{
						return false
					}
				})

				$("img").click(function(){
					this.src="kaptcha";
				});
			});
			
			
		</script>

	</head>
<body>
		<div id="login_header">
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册小卖铺会员</h1>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" 
									autocomplete="off" tabindex="1" name="username" id="username" /><span id="i1"></span>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" 
									autocomplete="off" tabindex="1" name="password" id="password" /><span id="i2"></span>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" 
									autocomplete="off" tabindex="1" name="repwd" id="repwd" /><span id="i3"></span>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" 
									autocomplete="off" tabindex="1" name="email" id="email" /><span id="i4"></span>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="c1"/><span id="i5"></span>
									<img alt="" src="kaptcha" style="float: right; margin-right: 40px;height: 40px;width: 70px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>