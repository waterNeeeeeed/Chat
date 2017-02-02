<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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