package app.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Role {
	
	//角色ID
	@Getter @Setter private Integer RoleId;
	
	//角色名称
	@Getter @Setter private String RoleName;
	
	//角色昵称
	@Getter @Setter private String NickName;
	
	//角色值
	@Getter @Setter private String RoleValue;
	
	//角色描述
	@Getter @Setter private String RoleDesc;
	
	//角色拥有的权限
	@Getter @Setter private Set<Right> rights = new HashSet<Right>();

	@Override
	public String toString() {
		return "Role [RoleId=" + RoleId + ", RoleName=" + RoleName + ", NickName=" + NickName + ", RoleValue=" + RoleValue + ", RoleDesc=" + RoleDesc + ", rights=" + rights + "]";
	}
	
}
