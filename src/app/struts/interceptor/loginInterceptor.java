package app.struts.interceptor;

import app.model.User;
import app.struts.action.userAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 登录拦截器 
 *
 */
public class loginInterceptor implements Interceptor {


	private static final long serialVersionUID = 6925656696431925624L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation paramActionInvocation) throws Exception {
		Action action = (Action) paramActionInvocation.getAction();
		String actionName = paramActionInvocation.getProxy().getActionName();
		if(action instanceof userAction){
			if("login_tlogin".equals(actionName) ||"login_login".equals(actionName)
					||"user_tregister".equals(actionName)||"user_register".equals(actionName)){
				return paramActionInvocation.invoke();
			}else{
				return "login";
			}
		}else{
			User user = (User) paramActionInvocation.getInvocationContext().getSession().get("user");
			if(user == null){
				//去登陆
				return "login" ;
			}
			else{
				//放行
//				if(action instanceof UserAware){
//					//注入实现UserAware接口的action
//					((UserAware)action).setUser(user);
//				}
				return paramActionInvocation.invoke();
			}
		}
	}

}
