package core.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.model.EntryPage;

/**
 * 
 * @summary:
 * 	在service层测试通用分页类
 */
public class entryPageTest {
	@Test
	public void pageTest(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		EntryPageService entryPageService = (EntryPageService) context.getBean("entryPageService");
		
		String hql = "from BusinessLog a order by a.startTime";
		EntryPage page = entryPageService.query(hql, 1, 100);
		System.out.println(page.getAllRow());
		System.out.println(page.getTotalPage());
		
		List<Object> list = page.getList();
		System.out.println(list);
		
		context.close();
	}
}
