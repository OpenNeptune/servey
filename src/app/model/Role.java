package app.model;

import java.util.HashSet;
import java.util.Iterator;
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

	//返回角色的权限ID，以数组的形式返回
	public String[] getRigthsId(){
		String[]  str = new String[rights.size()];
		Iterator<Right> iterator = rights.iterator();
		int i=0;
		while(iterator.hasNext()){
			String tem = String.valueOf(((Right)iterator.next()).getRightId());
			str[i] =tem;
			i++;
		}
		return str;
	}
	@Override
	public String toString() {
		return "Role [RoleId=" + RoleId + ", RoleName=" + RoleName + ", NickName=" + NickName + ", RoleValue=" + RoleValue + ", RoleDesc=" + RoleDesc + ", rights=" + rights + "]";
	}
	
}
