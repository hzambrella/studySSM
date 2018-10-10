<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--缓存禁止-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimal-ui" />
<meta name="renderer" content="webkit" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<script src="../js/vendor/jquery-3.2.1.min.js"></script>
<link href="/startSSM/css/login.css" rel="stylesheet" />
</head>
<body>
	<div id="top">
		<p></p>
	</div>
	<div id="middle">
		<div id="login_table_out">
			<form id="login_table">
				<label for="account">账号:</label><input id="account"
					placeholder="请输入账号" /><br /> <label for="password">密码:</label><input
					id="password" placeholder="请输入密码" /><br />
					<button id="doLogin">登录</button>
			</form>
			
		</div>
	</div>
</body>
<script>
	$("#doLogin").click(function(event) {
		event.preventDefault();
		var account = $("#account").val()
		var password = $("#password").val()
		
		$.ajax({
			url : "/startSSM/login/doLogin",
			method : 'post',
			dataType : 'json',
			data : {
				account : account,
				password : password,
			},
			success : function(data) {
				if (data.code == 0) {
					alert("登录成功")
					location.href=data.map.requestUrl;
				} else {
					alert(data.message)
				}
			},
			error : function(data, status, e) {
				console.log(e)
				alert("系统服务异常")
			}
		})
	})
</script>

</html>