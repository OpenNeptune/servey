package app.struts.action;

import java.util.Map;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.apache.struts2.interceptor.ApplicationAware;
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
public class userAction extends SupportAction<User>  implements SessionAware,ApplicationAware{

	private static final long serialVersionUID = 1130308026828193803L;

	@Getter @Setter private String registerCode;
	
	@Getter @Setter private String confirPassword;
	
	@Resource(name="userService")
	@Getter @Setter private UserService userService;
	
	@Getter @Setter private Map<String, Object> applicationMap;
	
	@Getter @Setter private Map<String, Object> sessionMap;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap =arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.applicationMap = arg0;
	}
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
			int max_right_pos = (Integer) applicationMap.get("max_right_pos");
			user.setRightSum(new long[max_right_pos + 1]);
			user.calculateRightSum();
			sessionMap.put("user", user);
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

}
