package app.service;

import app.model.Role;
import core.model.EntryPage;


/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface RoleService {
	
	public void save(Role model);
	
	public EntryPage query(int page, int size);

	
}
