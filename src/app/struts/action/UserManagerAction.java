package app.struts.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import core.model.EntryPage;
import core.struts.Action.SupportAction;
import lombok.Getter;
import lombok.Setter;
import app.model.User;
import app.service.UserService;


@Controller("userManagerAction")
@Scope("prototype")
public class UserManagerAction extends SupportAction<User>  implements SessionAware{

	private static final long serialVersionUID = 6049594383880144234L;
	
	@Getter @Setter private Integer  userid;
	
	@Getter @Setter private EntryPage pageList = new EntryPage();

	@Resource(name="userService")
	@Getter @Setter private UserService userService;
	
	@Getter @Setter private Map<String, Object> sessionMap;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap =arg0;
	}
	
	/**
	 * @Action:用户和角色关联
	 */
	public void validateExec_edit(){
		if(!core.util.validate.isValid(userid)){
			addActionError("非法的记录");
		}
		if(hasActionErrors()){
			return;
		}
		log.info("validateExec_edit:"+model);
	}
	
	public void prepareExec_edit(){
		model = userService.get(userid);
		log.info("prepareExec_edit:"+model);
	}
	public String exec_edit(){
		sessionMap.put("update_userId", model.getUserid());
		return "edit";
	}
	
	/**
	 * @Action:报存
	 */
	public void prepareExec_save(){
		if(userid != null){
			model = userService.get(userid);
		}else{
			model = new User();
		}
		log.info("prepareExec_save:["+userid+"]"+model);
	}
	public void validateExec_save(){
		System.out.println("validateExec_save:"+model);
		Integer session_updateUserId = (Integer)sessionMap.get("update_userId");
		if(model.getUserid().longValue() != session_updateUserId.longValue()){
			log.info(session_updateUserId+"|"+model.getUserid());
			addActionError("非法的操作");
		}else{
			sessionMap.remove("update_userId");
		}
		if(hasActionErrors()){
			return;
		}
	}
	public String exec_save(){
		userService.saveOrUpdate(model);
		return "list";
	}


	
	/**
	 * @Action:罗列所有的用户
	 */
	public String exec_list(){
		pageList = (EntryPage) userService.query(pageList.getCurrentPage(), pageList.getPageSize());
		return SUCCESS;
	}
}
