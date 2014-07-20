package app.service.impl;


import org.springframework.stereotype.Service;

import app.model.Right;
import app.service.RightService;
import core.model.EntryPage;
import core.service.impl.SupportServiceImpl;

@Service("rightService")
public class RightServiceImpl extends SupportServiceImpl<Right> implements RightService {

	@Override
	public void save(Right model) {
		//实现自己的业务逻辑
		this.saveEntry(model);
	}

	@Override
	public EntryPage query(int page, int size) {
		/**
		 * 在业务层实现查询语句的业务逻辑
		 */
		String hql ="from Right a order by a.RightId desc";
		return super.query(hql, page, size);
	}

	@Override
	public void delete(Right model) {
		/**
		 * 添加自己的业务逻辑
		 */
		this.deleteEntryById(model);
	}



}
