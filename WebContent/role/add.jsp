<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增角色</title>
</head>
<body>
<s:form action="role_save.action" method="post" theme="xhtml">
	<s:textfield name="RoleName" label="RoleName"></s:textfield>
	<s:textfield name="NickName" label="NickName"></s:textfield>
	<s:textfield name="RoleDesc" label="RoleDesc"></s:textfield>
	<s:submit value="添加"></s:submit>
</s:form>
</body>
</html>