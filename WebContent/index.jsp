<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:property value="#session.user.username"/>
	<s:a action="login_tlogin.action">用户登录</s:a>
	<s:a action="user_tregister.action">用户注册</s:a>
	<s:a action="log_list.action">业务日志</s:a>
	<s:a action="role_list.action">角色管理</s:a>
</body>
</html>