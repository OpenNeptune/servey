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
		<th>序号</th>
		<th>功能名称</th>
		<th>功能昵称</th>
		<th>功能分组</th>
		<th>功能编码</th>
		<th>功能描述</th>
		<th>操作</th>
	</tr>
	<s:iterator value="pageList.getList()" status="st">
		<tr>
			<td><s:property value="%{#st.index}"/></td>
			<s:hidden value="RightId"></s:hidden>
			<td><s:property value="RightName"/></td>
			<td><s:property value="uri"/></td>
			<td><s:property value="RightPos"/></td>
			<td><s:property value="RightCode"/></td>
			<td><s:property value="RightDesc"/></td>
			<td>
				<s:a href="right_edit.action?RightId=%{RightId }" >修改</s:a>
				&nbsp;&nbsp;
				<s:a href="right_delete.action?RightId=%{RightId }" >删除</s:a>
			</td>
		</tr>
	</s:iterator>
</table>
<div class="nav">
	总记录:<s:property value="pageList.allRow"/> 
	当前页:<s:property value="pageList.totalPage"/>
	<s:if test="pageList.isHasPreviousPage()">
	<s:a href="right_list.action?pageList.currentPage=%{pageList.currentPage - 1}">上一页</s:a>
	</s:if>
	<s:if test="pageList.isHasNextPage()">
	<s:a href="right_list.action?pageList.currentPage=%{pageList.currentPage + 1}">下一页</s:a>
	</s:if>
	<s:a action="right_add.action">新增功能</s:a>
	<s:a action="right_refresh.action">功能刷新</s:a>
</div>
</body>
</html>