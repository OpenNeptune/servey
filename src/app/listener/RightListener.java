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
import app.service.RightService;
/**
 * 
 *@Summary:
 *	通过Spring初始化，将所有的权限信息放入的aplicationContext中
 */
@Component
@SuppressWarnings("rawtypes")
public class RightListener implements ApplicationListener,ServletContextAware{
	
	@Resource(name="rightService")
	@Getter @Setter private RightService rightService;
	
	private ServletContext context;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		//上下文刷新事件
		if(arg0 instanceof ContextRefreshedEvent){
			//查出所有权限
			List<Right> rights = rightService.findAll();
			Map<String, Right> map = new HashMap<String, Right>();
			for(Right r : rights){
				map.put(r.getUri(), r);
			}
			if(context != null){
				//初始化所有权限到Application中!!!!
				context.setAttribute("all_rights_map", map);
				//System.out.println("设置功能Map到Apllication中");
			}
		}
	}

}
