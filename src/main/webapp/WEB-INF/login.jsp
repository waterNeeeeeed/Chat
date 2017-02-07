<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.1.1.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body style="text-align:center">
<div align="center" style="border:solid 1px;width:600px;margin:auto">
<h2>用户登录</h2>
<form id="form1" method="post">
<table>
	<tr>
		<td>用户名：</td>
		<td><input type="text" id="username" name="username"/></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password" id="password" name="password"/></td>
	</tr>
</table>
<input type="button" value="register" onclick="submit_form(this)"/>
<input type="button" value="login" onclick="submit_form(this)"/>

</form>
</div>
<script type="text/javascript">
	function submit_form(event){
		if (event.value == "register")
		{
			document.getElementById("form1").action = "reg.do";
			document.getElementById("form1").submit();
			return ;
		}
		if (event.value == "login")
		{
			document.getElementById("form1").action = "login.do";
			document.getElementById("form1").submit();
			return ;
		}
	}
</script>
</body>
</html>