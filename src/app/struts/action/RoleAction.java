package app.struts.action;

import javax.annotation.Resource;

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
	
	private EntryPage pageList = new EntryPage();
	
	@Resource(name="roleService")
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public EntryPage getPageList() {
		return pageList;
	}
	public void setPageList(EntryPage pageList) {
		this.pageList = pageList;
	}
	
	
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
	public String exec_save(){
		roleService.save(model);
		return "list";
	}
	
	/**
	 * 更新一个角色 
	 */
	public String exec_update(){
		return "list";
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
