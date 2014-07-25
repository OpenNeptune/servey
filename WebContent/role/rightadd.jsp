<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加功能</title>
</head>
<body>
<s:form action="right_save.action" method="post" theme="xhtml">
	<s:token></s:token>
	<s:textfield name="RightName" label="功能名称"></s:textfield>
	<s:textfield name="uri" label="功能地址"></s:textfield>
	<s:textfield name="RightDesc" label="功能描述"></s:textfield>
	<s:submit value="添加"></s:submit>
</s:form>
</body>
</html>