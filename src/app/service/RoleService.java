package app.service;

import app.model.Role;
import core.model.EntryPage;
import core.service.SupportService;



/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface RoleService extends SupportService<Role>{

	EntryPage query(int currentPage, int pageSize);
	
	
}
