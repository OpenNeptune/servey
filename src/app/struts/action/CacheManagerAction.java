package app.struts.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.apache.struts2.interceptor.ApplicationAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.Right;
import app.model.Role;
import app.service.RightService;
import app.service.RoleService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @Summary:主要通过前台页面刷新，来刷新Application范围内的属性
 * 
 */
@Controller("cacheManagerAction")
@Scope("prototype")
public class CacheManagerAction extends ActionSupport implements ApplicationAware{

	private static final long serialVersionUID = -6298676072872924194L;

	@Getter @Setter private Map<String, Object> applicationMap;
	
	@Resource(name="rightService")
	@Getter @Setter private RightService rightService;
	
	@Resource(name="roleService")
	@Getter @Setter private RoleService roleService;
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.applicationMap = arg0;
	}

	public String exec_refersh(){
		List<Right> rights = rightService.findAll();
		Map<String, Right> right_map = new HashMap<String, Right>();
		for(Right r : rights){
			right_map.put(r.getUri(), r);
		}

		
		List<Role> roles = roleService.findAll();
		Map<String,Role> role_map = new HashMap<String,Role>();
		for(Role role : roles){
			role_map.put(String.valueOf(role.getRoleId()),role);
		}
		
		
		applicationMap.put("all_rights_map", right_map);
		
		applicationMap.put("all_roles_map", role_map);
		
		return SUCCESS;
	}
}
