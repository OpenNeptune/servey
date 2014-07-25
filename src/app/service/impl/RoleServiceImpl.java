package app.service.impl;



import org.springframework.stereotype.Service;

import app.model.Role;
import app.service.RoleService;
import core.model.EntryPage;
import core.service.impl.SupportServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends SupportServiceImpl<Role> implements RoleService{



	public EntryPage query(int page, int size) {
		/**
		 * 在业务层实现查询语句的业务逻辑
		 */
		String hql ="from Role a order by a.RoleId desc";
		return super.query(hql, page, size);
	}

	
}
