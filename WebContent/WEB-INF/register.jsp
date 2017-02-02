<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>用户注册</h2>
<form id="form1" method="post" action="register">
<table>
	<tr>
		<td>用户名：</td>
		<td><input type="text" id="username" name="username"/></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password" id="password" name="password"/></td>
	</tr>
	<tr>
		<td>年龄：</td>
		<td><input type="text" id="age" name="age"/></td>
	</tr>
</table>
<input type="submit" value="register" />

</form>

</body>
</html>