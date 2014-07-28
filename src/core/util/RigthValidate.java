package core.util;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import app.model.Right;
import app.model.User;

@SuppressWarnings("unchecked")
public class RigthValidate {
	public static Logger log = Logger.getLogger(RigthValidate.class);
	
	public static boolean hasRigth(String namespace,String actionName,HttpServletRequest req,Object action){
		boolean result = false;
		if(!validate.isValid(namespace)|| "/".equals(namespace)){
			namespace = "" ;
		}
		//将超链接的参数部分滤掉 ?xxxx
		if(actionName.contains("?")){
			actionName = actionName.substring(0, actionName.indexOf("?"));
		}
		String url = namespace + "/" + actionName;
		HttpSession session = req.getSession();
		
		ServletContext sc = session.getServletContext();
		Map<String, Right> map = (Map<String, Right>) sc.getAttribute("all_rights_map");
		Right r = map.get(url);
		log.info("权限校验:uri:"+url+"|权限对象:"+r );
		//公共资源?
		if(r == null || r.isPublic()){
			result  = true ;
		}
		else{
			User user = (User) session.getAttribute("user");
			//登陆?
			if(user == null){
				result = false ;
			}
			else{
				if(user.isAdmin()){
					result = true;
				}else{
					if(user.hasRight(r)){
						result = true;
					}else{
						result = false;
					}
				}
				String[] array = user.getRoleArray();
				StringBuffer sbuf = new StringBuffer();
				for(String s:array){
					sbuf.append(s);
					sbuf.append(",");
				}
				log.info("权限校验:"+ r.getUri()+"|"+user.getUsername()+"|"+sbuf.toString());
			}
		}
		return result;
	}
}
