package core.struts.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

import core.util.RigthValidate;

public class RigthFilterIntercetor implements Interceptor{

	private static final long serialVersionUID = 2853964574730044535L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Object action = arg0.getAction();
		ActionProxy proxy = arg0.getProxy();
		String ns = proxy.getNamespace();
		String actionName = proxy.getActionName();
		if(RigthValidate.hasRigth(ns, actionName, ServletActionContext.getRequest(), action)){
			return arg0.invoke();
		}
		return "login";
	}

}
