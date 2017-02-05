<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onLoad="sendEmptyRequest();">
<div style="width:780px;border:1px solid black;text-align:center">
<p>
<textarea id="chatArea" cols="90" row="30"
	readonly="readonly">${requestScope.tip }</textarea>
</p>
<input type="text" id="chatMsg" name="chatMsg" size="90"/>
<input type="button" id="chatSend" name="chatSend" value="发送" onclick="sendRequest();"/>
</div>
<script type="text/javascript">
var input = document.getElementById("chatMsg");
input.focus();
var XMLHttpReq;
function createXMLHttpRequest(){
	XMLHttpReq = new XMLHttpRequest();
}
function sendRequest(){
	
	var chatMsg = document.getElementById("chatMsg").value;
	//alert(chatMsg);
	createXMLHttpRequest();
	var url = "chat.do";
	XMLHttpReq.open("POST", url, true);
	XMLHttpReq.setRequestHeader("Content-Type",
		"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = processResponse;
	input.value = "";
	XMLHttpReq.send("chatMsg="+chatMsg);
	
}
function processResponse(){
	if (XMLHttpReq.readyState == 4){
		if (XMLHttpReq.status == 200){
			document.getElementById("chatArea").value
				= XMLHttpReq.responseText;
		}
		else{
			//alert("unnormal");
		}
	}
}
function sendEmptyRequest(){
	createXMLHttpRequest();
	var url = "chat.do";
	XMLHttpReq.open("POST", url, true);
	XMLHttpReq.setRequestHeader("Content-Type", 
		"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = processResponse;
	XMLHttpReq.send(null);
	setTimeout("sendEmptyRequest()", 800);
}


</script>

</body>
</html>