<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/form.css">
<title>用户注册</title>
</head>
<body>
	<s:form action="/user_register" method="post" cssClass="register">
		UserName:<s:textfield name="username"/><br>
		E-Mail:<s:textfield name="email"/><br>
		Password:<s:password name="password"/><br>
		Re-Password<s:password name="confirPassword"/><br>
		<s:fielderror cssClass="errormsg"/>
		<s:submit value="JOIN-IN"></s:submit>
	</s:form>
</body>
</html>