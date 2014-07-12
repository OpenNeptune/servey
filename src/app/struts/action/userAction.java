package app.struts.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.User;
import app.service.UserService;
import core.struts.Action.SupportAction;
import core.util.sec;
import core.util.validate;


@Controller("userAction")
@Scope("prototype")
public class userAction extends SupportAction<User> {

	private static final long serialVersionUID = 1130308026828193803L;

	private String registerCode;
	
	private String confirPassword;
	
	@Resource
	private UserService userService;
	
	/**
	 * 跳转到用户注册页面 
	 */
	public String exec_tregister(){
		return "register";
	}
	
	/**
	 * 用户注册
	 */
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
	
	

}
