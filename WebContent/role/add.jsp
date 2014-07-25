<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/jquery.js"></script>
<title>角色管理</title>
<script type="text/javascript">
	var rigth_list ="<s:property value="%{model.getRigthsId() }"/>";
	$(function(){
		arr_list = rigth_list.split(", ");
		console.log(arr_list);
		jQuery.each($("input[name='rights']"),function(){
			if(arr_list.indexOf($(this).val()) != -1){
				$(this).attr("checked",true);
			}
		});
	});
</script>
</head>
<body>
<s:debug></s:debug>
<s:form action="role_save.action" method="post" theme="xhtml">
	<s:hidden name="RoleId" value="%{model.RoleId}"></s:hidden>
	<s:textfield name="model.RoleName" label="RoleName"></s:textfield>
	<s:textfield name="model.NickName" label="NickName"></s:textfield>
	<s:textfield name="model.RoleDesc" label="RoleDesc"></s:textfield>
	
	<tr>
		<td>rights</td>
		<td>
			<s:iterator value="#application.all_rights_map" status="st">
				<input type="checkbox" name="rights" value="<s:property value="%{value.RightId }"/>"><s:property value="%{value.RightName}"/><br>
			</s:iterator>
		</td>
	</tr>
	<s:submit value="添加"></s:submit>
</s:form>
</body>
</html>