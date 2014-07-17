package app.model;

import java.util.HashSet;
import java.util.Set;

public class Role {
	
	//角色ID
	private Integer RoleId;
	
	//角色名称
	private String RoleName;
	
	//角色昵称
	private String NickName;
	
	//角色值
	private String RoleValue;
	
	//角色描述
	private String RoleDesc;
	
	//角色拥有的权限
	private Set<Right> rights = new HashSet<Right>();

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public String getRoleValue() {
		return RoleValue;
	}

	public void setRoleValue(String roleValue) {
		RoleValue = roleValue;
	}

	public String getRoleDesc() {
		return RoleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		RoleDesc = roleDesc;
	}

	public Set<Right> getRights() {
		return rights;
	}

	public void setRights(Set<Right> rights) {
		this.rights = rights;
	}
	
}
