package app.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import app.model.Right;
import app.model.Role;
import app.service.RightService;
import app.service.RoleService;
/**
 * 
 *@Summary:
 *	通过Spring初始化，将全局信息放入的aplicationContext中
 */
@Component
@SuppressWarnings("rawtypes")
public class ApplicationMapListener implements ApplicationListener,ServletContextAware{
	
	@Resource(name="rightService")
	@Getter @Setter private RightService rightService;
	
	@Resource(name="roleService")
	@Getter @Setter private RoleService roleService;
	
	private ServletContext context;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		if(arg0 instanceof ContextRefreshedEvent){
			//查出所有权限
			List<Right> rights = rightService.findAll();
			Map<String, Right> right_map = new HashMap<String, Right>();
			for(Right r : rights){
				right_map.put(r.getUri(), r);
			}
			
			int max_right_pos = rightService.getMaxRightPos();
			
			List<Role> roles = roleService.findAll();
			Map<String,Role> role_map = new HashMap<String,Role>();
			for(Role role : roles){
				role_map.put(String.valueOf(role.getRoleId()),role);
			}
			
			if(context != null){
				//初始化到Application中!!!!
				context.setAttribute("all_rights_map", right_map);
				
				context.setAttribute("max_right_pos", max_right_pos);
				
				context.setAttribute("all_roles_map", role_map);
			}
		}
	}

}
