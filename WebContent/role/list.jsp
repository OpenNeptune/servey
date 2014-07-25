<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Stylesheet" type="text/css" href="style/table.css">
</head>
<body>
<table>
	<tr>
		<th width="10%">角色名称</th>
		<th width="10%">角色呢称</th>
		<th width="60%">角色描述</th>
		<th width="20%">操作</th>
	</tr>
	<s:iterator value="pageList.getList()">
		<tr>
			<s:hidden value="RoleId"></s:hidden>
			<td><s:property value="RoleName"/></td>
			<td><s:property value="NickName"/></td>
			<td><s:property value="RoleDesc"/></td>
			<td>
				<s:a href="role_edit.action?RoleId=%{RoleId }" >修改</s:a>
				&nbsp;&nbsp;
				<s:a href="role_delete.action?RoleId=%{RoleId }" >删除</s:a>
			</td>
		</tr>
	</s:iterator>
</table>
<div class="nav">
	总记录:<s:property value="pageList.allRow"/> 
	当前页:<s:property value="pageList.totalPage"/>
	<s:if test="pageList.isHasPreviousPage()">
	<s:a href="role_list.action?pageList.currentPage=%{pageList.currentPage - 1}">上一页</s:a>
	</s:if>
	<s:if test="pageList.isHasNextPage()">
	<s:a href="role_list.action?pageList.currentPage=%{pageList.currentPage + 1}">下一页</s:a>
	</s:if>
	<s:a action="role_add.action">新增角色</s:a>
</div>
</body>
</html>