package app.struts.action;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

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
	
	@Getter @Setter private EntryPage pageList = new EntryPage();
	
	@Getter @Setter private Integer RightId;

	@Resource(name="rightService")
	@Getter @Setter private RightService rightService;

	
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
	public void prepareExec_save(){
		if(model != null && model.getRightId() != null){
			model = rightService.get(RightId);
		}else{
			model = new Right();
		}
	}
	public void validateExec_save(){

	}
	public String exec_save(){
		rightService.saveOrUpdate(model);
		return "list";
	}

	/**
	 * 编辑权限
	 */
	public void prepareExec_edit(){
		model =  rightService.get(RightId);
		System.out.println("prepare:"+model);
	}
	
	public void validateExec_edit(){
		if(!core.util.validate.isValid(RightId)){
			addFieldError("RightId","非法的记录ID");
		}
		if(hasErrors()){
			return;
		}
	}
	public String exec_edit(){
		return "edit";
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
	
	/**
	 * 刷新系统的现有的功能模块
	 */
	public String exec_refresh(){
		rightService.refreshRight();
		return "list";
	}
}
