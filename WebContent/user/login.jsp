<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/form.css">
<title>用户登录</title>
</head>
<body>
	<s:form action="/login_login" method="post" cssClass="register">
		<div class="form-tr">
				<div>UserName:</div>
				<s:textfield name="username"/>
				<s:fielderror cssClass="errormsg"><s:param>username</s:param></s:fielderror>
		</div>
		<div class="form-tr">
				<div>Password:</div>
				<s:password name="password"/>
				<s:fielderror cssClass="errormsg"><s:param>password</s:param></s:fielderror>
		</div>
		<s:submit value="LOGIN"></s:submit>
		<s:a action="/user_tregister.action"></s:a>
	</s:form>
</body>
</html>