package app.converter;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import app.model.Role;
import app.service.RoleService;
@SuppressWarnings("rawtypes")
public class User_RoleConverter extends StrutsTypeConverter {

	public static Logger log = Logger.getLogger(User_RoleConverter.class);
	
	@Resource(name="roleService")
	@Getter @Setter public RoleService roleService;
	
	public User_RoleConverter() {
		log.info("app.model.Role类型转换器创建...");
	}

	@Override
	public Object convertFromString( Map arg0, String[] arg1, Class arg2) {
		Role obj = null;
		if(arg2 == Role.class){
			Iterator<Role> iterator = roleService.getByArray(arg1).iterator();
			while (iterator.hasNext()) {
				obj = (Role) iterator.next();
			}
		}
		log.info("类型转换FromString:"+arg0+"|"+arg1+"|"+arg2+"|"+obj);
		return obj;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		String result=null;
		if(arg1 ==  Role.class){
			Role obj = (Role) arg1;
			result =String.valueOf(obj.getRoleId());
		}
		log.info("类型转换ToString:"+arg0+"|"+arg1+"|"+result);
		return result;
	}

}
