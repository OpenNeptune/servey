package app.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import app.model.Role;
import app.service.RoleService;
import core.model.EntryPage;
import core.service.impl.SupportServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends SupportServiceImpl<Role> implements RoleService{

	@Override
	public int batchByHQL(String hql, Object... objects) {
		return super.batchByHQL(hql, objects);
	}

	@Override
	public List<Role> getEntryListByHQL(String hql, Object... objects) {
		return super.getEntryListByHQL(hql, objects);
	}

	@Override
	public List<Role> getEntryListBySQL(String sql, Object... objects) {
		return super.getEntryListBySQL(sql, objects);
	}

	@Override
	public List<Role> findEntityByHQL(String hql, Object... objects) {
		return super.findEntityByHQL(hql, objects);
	}

	public EntryPage query(int page, int size) {
		/**
		 * 在业务层实现查询语句的业务逻辑
		 */
		String hql ="from Role a order by a.RoleId desc";
		return super.query(hql, page, size);
	}
	
	public void save(Role model){
		super.saveEntry(model);
	}
	
}
