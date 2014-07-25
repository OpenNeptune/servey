package app.converter;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import app.model.Right;
import app.service.RightService;
@SuppressWarnings("rawtypes")
public class Role_RightConverter extends StrutsTypeConverter {
	
	public static Logger log = Logger.getLogger(Role_RightConverter.class);
	
	@Resource(name="rightService")
	@Getter @Setter public RightService rightService;

	@Override
	public Object convertFromString( Map arg0, String[] arg1, Class arg2) {
		Right obj = null;
		if(arg2 == Right.class){
			Iterator<Right> iterator = rightService.getByArray(arg1).iterator();
			while (iterator.hasNext()) {
				obj = (Right) iterator.next();
			}
		}
		log.info("类型转换FromString:"+arg0+"|"+arg1+"|"+arg2+"|"+obj);
		return obj;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		String result=null;
		if(arg1 ==  Right.class){
			Right obj = (Right) arg1;
			result =String.valueOf(obj.getRightId());
		}
		log.info("类型转换ToString:"+arg0+"|"+arg1+"|"+result);
		return result;
	}

}
