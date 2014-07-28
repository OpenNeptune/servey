<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/jquery.js"></script>
<title>用户管理</title>
<script type="text/javascript">
	var role_list ="<s:property value="%{model.getRoleArray() }"/>";
	$(function(){
		arr_list = role_list.split(", ");
		console.log(arr_list);
		jQuery.each($("input[name='model.roles']"),function(){
			if(arr_list.indexOf($(this).val()) != -1){
				$(this).attr("checked",true);
			}
		});
	});
</script>
</head>
<body>
	<s:debug></s:debug>
	<s:form action="users_save.action" method="post" theme="xhtml">
		<s:hidden name="userid" value="%{model.userid}"></s:hidden>
		用户名：<s:property value="username"/>
		<tr>
			<td>角色</td>
			<td>
				<s:iterator value="#application.all_roles_map" status="st">
					<input type="checkbox" name="model.roles" value="<s:property value="%{value.RoleId}"/>"><s:property value="%{value.RoleName}"/><br>
				</s:iterator>
			</td>
		</tr>
		<s:submit value="更新"></s:submit>
	</s:form>
</body>
</html>