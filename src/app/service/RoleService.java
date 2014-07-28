package app.service;

import java.util.Set;

import app.model.Role;
import core.model.EntryPage;
import core.service.SupportService;



/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface RoleService extends SupportService<Role>{

	public EntryPage query(int currentPage, int pageSize);
	
	public Set<Role> getByArray(String[] roleId);
}
