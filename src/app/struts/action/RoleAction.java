package app.struts.action;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.Role;
import app.service.RoleService;
import core.model.EntryPage;
import core.struts.Action.SupportAction;

/**
 * 
 * @summary:
 * 		角色管理的Action
 */
@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends SupportAction<Role>{

	private static final long serialVersionUID = -4596824964084141573L;
	
	@Getter @Setter private EntryPage pageList = new EntryPage();
	
	@Resource(name="roleService")
	@Getter @Setter private RoleService roleService;
	
	@Getter @Setter private Integer RoleId;
	
	
	//
	//Action方法
	//
	
	/**
	 * 跳转到的添加角色的页面
	 */
	public String exec_add(){
		return "add_page";
	}
	/**
	 * 新增一个角色 
	 */
	public void prepareExec_save(){
		if(RoleId != null){
			model = roleService.get(RoleId);
		}else{
			model = new Role();
		}
		log.info("prepare:"+model);
	}
	public void validateExec_save(){
		if(RoleId != null){

		}
		if(hasErrors()){
			return;
		}
	}
	public String exec_save(){
		System.out.println(model);
		roleService.saveOrUpdate(model);
		return "list";
	}
	
	/**
	 * 更新一个角色 
	 */
	public void prepareExec_edit(){
		if(RoleId != null){
			model = roleService.get(RoleId);
		}else{
			model = new Role();
		}
	}
	public void validateExec_edit(){
		if(!core.util.validate.isValid(RoleId)){
			addFieldError("RoleId","非法的记录ID");
			log.info("validate:非法的记录ID");
		}
		if(hasErrors()){
			return;
		}
	}
	public String exec_edit(){
		return "edit";
	}
	
	/**
	 * 删除一个角色
	 */
	public String exec_delete(){
		return "list";
	}
	
	/**
	 * 查询所有的用户，可以按页查询。当然自己可以可以实现自动以的分组查询
	 */
	public String exec_list(){
		pageList = roleService.query(pageList.getCurrentPage(),pageList.getPageSize());
		return SUCCESS;
	}
}
