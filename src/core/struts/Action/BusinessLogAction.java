package core.struts.Action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import core.model.EntryPage;
import core.service.EntryPageService;
/**
 * 
 * @summary
 * 	由于结果列表直接封装在了EntryPage实体中，所以此处不需要指定具体的实体
 * 	在调用Service层的方法是通过hql传入即可，返回想要对象的列表
 */

@Controller("businessLogAction")
public class BusinessLogAction extends SupportAction<EntryPage> {

	private static final long serialVersionUID = 1L;

	@Resource(name="entryPageService")
	private EntryPageService entryPageService;
	
	public void setEntryPageService(EntryPageService entryPageService) {
		this.entryPageService = entryPageService;
	}

	public String exec_listlog(){
		/**
		 * 注意此处的业务HQL应该放在Service层，此处为了方便测试直接写在了Controller层了，
		 * 并且此处没有使用任何过滤技术。即存在SQLInject
		 */
		String hql="from BusinessLog a order by a.startTime desc, a.id desc";
		model = entryPageService.query(hql, model.getCurrentPage(), model.getPageSize());
		return SUCCESS;
	}
	
}
