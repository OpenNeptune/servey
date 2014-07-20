package app.struts.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.Right;
import app.service.RightService;
import core.model.EntryPage;
import core.struts.Action.SupportAction;

/**
 * 
 * @summary:
 * 		功能管理的Action
 */
@Controller("rightAction")
@Scope("prototype")
public class RightAction extends SupportAction<Right>{

	private static final long serialVersionUID = -4596824964084141573L;
	
	private EntryPage pageList = new EntryPage();
	
	@Resource(name="rightService")
	private RightService rightService;

	public RightService getRightService() {
		return rightService;
	}
	public void setRightService(RightService rightService) {
		this.rightService = rightService;
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
	 * 跳转到的添加功能的页面
	 */
	public String exec_add(){
		return "add_page";
	}
	/**
	 * 新增一个功能
	 */
	public String exec_save(){
		rightService.save(model);
		return "list";
	}
	
	/**
	 * 更新一个功能 
	 */
	public String exec_update(){
		return "list";
	}
	
	/**
	 * 删除一个功能
	 */
	public String exec_delete(){
		rightService.delete(model);
		return "list";
	}
	
	/**
	 * 查询所有的功能，可以按页查询。当然自己可以可以实现自动以的分组查询
	 */
	public String exec_list(){
		pageList = rightService.query(pageList.getCurrentPage(),pageList.getPageSize());
		return SUCCESS;
	}
}
