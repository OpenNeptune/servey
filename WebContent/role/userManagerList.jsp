<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Stylesheet" type="text/css" href="style/table.css">
<title>用户管理</title>
</head>
<body>
<table>
	<tr>
		<th>序号</th>
		<th>用户名称</th>
		<th>注册邮箱</th>
		<th>用户昵称</th>
		<th>用户密码</th>
		<th>操作</th>
	</tr>
	<s:iterator value="pageList.getList()" status="st">
		<tr>
			<td><s:property value="%{#st.index}"/></td>
			<s:hidden value="userid"></s:hidden>
			<td><s:property value="username"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="nickname"/></td>
			<td><s:property value="password"/></td>
			<td>
				<s:a href="users_edit.action?userid=%{userid }" >修改</s:a>
				&nbsp;&nbsp;
				<s:a href="#一般不建议提供删除功能，可以提供类似用户锁定的功能" >删除</s:a>
			</td>
		</tr>
	</s:iterator>
</table>
<div class="nav">
	总记录:<s:property value="pageList.allRow"/> 
	当前页:<s:property value="pageList.totalPage"/>
	<s:if test="pageList.isHasPreviousPage()">
	<s:a href="users_list.action?pageList.currentPage=%{pageList.currentPage - 1}">上一页</s:a>
	</s:if>
	<s:if test="pageList.isHasNextPage()">
	<s:a href="users_list.action?pageList.currentPage=%{pageList.currentPage + 1}">下一页</s:a>
	</s:if>
</div>
</body>
</html>