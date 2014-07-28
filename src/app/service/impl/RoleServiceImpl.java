package app.service.impl;



import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import app.model.Role;
import app.service.RoleService;
import core.model.EntryPage;
import core.service.impl.SupportServiceImpl;
import core.util.validate;

@Service("roleService")
public class RoleServiceImpl extends SupportServiceImpl<Role> implements RoleService{



	public EntryPage query(int page, int size) {
		/**
		 * 在业务层实现查询语句的业务逻辑
		 */
		String hql ="from Role a order by a.RoleId desc";
		return super.query(hql, page, size);
	}

	public Set<Role> getByArray(String[] roleId){
		Set<Role> set = new HashSet<Role>();
		if(validate.isValid(roleId)){
			for(int i=0;i<roleId.length;i++){
				Role role = this.get(Integer.parseInt(roleId[i]));
				set.add(role);
			}
		}
		return set;
	}
}
