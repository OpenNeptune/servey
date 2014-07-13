package app.struts.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.User;
import app.service.UserService;
import core.struts.Action.SupportAction;
import core.util.sec;
import core.util.validate;


@Controller("userAction")
@Scope("prototype")
public class userAction extends SupportAction<User>  implements SessionAware{

	private static final long serialVersionUID = 1130308026828193803L;

	private String registerCode;
	
	private String confirPassword;
	
	@Resource
	private UserService userService;
	
	private Map<String, Object> sessionMap;
	
	/**
	 * 用户注册
	 */
	public String exec_tregister(){
		return "register";
	}

	public String exec_register(){
		model.setPassword(sec.md5(model.getPassword()));
		userService.save(model);
		return SUCCESS;
	}

	public void validateExec_register(){
		//输入校验
		if(!core.util.validate.isValid(model.getUsername())){
			addFieldError("username", "用户名不能为空");
		}
		if(!validate.isValid(model.getEmail())){
			addFieldError("email", "邮箱地址不能为空");
		}
		if(!validate.isValid(model.getPassword())){
			addFieldError("password","密码不能为空");
		}
		if(hasErrors()){
			return;
		}
		//有效性校验
		if(!validate.isEmail(model.getEmail())){
			addFieldError("email", "不是一个有效的邮箱地址");
		}
		if(!model.getPassword().equals(confirPassword)){
			addFieldError("confirPassword", "俩次密码不一致");
		}
		if(hasErrors()){
			return;
		}
		//可用性检测
		if(!userService.isRegisterByEmail(model.getEmail())){
			addFieldError("email", "该邮箱已经被注册");
		}
		if(hasErrors()){
			return;
		}
		
	}

	
	/**
	 * 用户登录
	 */
	public String exec_tlogin(){
		return "input";
	}
	public String exec_login(){
		String result="input";
		User user = userService.login(model);
		if(user != null){
			sessionMap.put("user", model);
			result ="login_success";
		}else{
			addFieldError("password","错误的用户名和密码");
		}
		return result;
	}
	public void validateExec_login(){
		if(!validate.isValid(model.getUsername())){
			addFieldError("username", "用户名不能为空");
		}
		if(!validate.isValid(model.getPassword())){
			addFieldError("password", "密码不能为空");
		}
		if(hasErrors()){
			return;
		}
	}
	
	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	public String getConfirPassword() {
		return confirPassword;
	}

	public void setConfirPassword(String confirPassword) {
		this.confirPassword = confirPassword;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap =arg0;
	}
}
