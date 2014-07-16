package core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import core.dao.EntryPageDao;
import core.model.EntryPage;
import core.service.EntryPageService;

@Service("entryPageService")
public class EntryPageServiceImpl implements EntryPageService {
	
	@Resource(name="entryPageDao")
	private EntryPageDao dao;
	
	
	public void setDao(EntryPageDao dao) {
		this.dao = dao;
	}

	@Override
	public EntryPage query(String hql, int page, int size) {
		//实现自己的业务逻辑
		EntryPage pages = dao.query(hql, page, size);
		
		return pages;
	}

}
