<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Stylesheet" type="text/css" href="style/table.css">
<title>业务层的操作日志</title>
<style type="text/css">
	table{
		font-family: verdana,arial,sans-serif;
		font-size:11px;
		color:#333333;
		border-width: 1px;
		border-color: #666666;
		border-collapse: collapse;
		width: 98%
	}
	th{
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #666666;
		background-color: #dedede;
	}
	td{
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #666666;
		background-color: #ffffff;
	}
</style>
</head>
<body>
<table>
	<tr>
		<th>行号</th>
		<th>操作时间</th>
		<th>操作人</th>
		<th>操作项</th>
		<th>操作结果</th>
	</tr>
	<s:iterator value="model.getList()">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="startTime"/></td>
			<td><s:property value="username"/></td>
			<td><s:property value="operationName"/></td>
			<td><s:property value="result"/></td>
		</tr>
	</s:iterator>
</table>
<div class="nav">
	总记录:<s:property value="model.allRow"/> 
	|页数:<s:property value="model.totalPage"/>
	<s:if test="model.isHasPreviousPage()">
	<s:a href="log_list.action?model.currentPage=%{model.currentPage - 1}">上一页</s:a>
	</s:if>
	<s:if test="model.isHasNextPage()">
	<s:a href="log_list.action?model.currentPage=%{model.currentPage + 1}">下一页</s:a>
	</s:if>
</div>
</body>
</html>