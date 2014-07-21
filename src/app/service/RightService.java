package app.service;

import app.model.Right;
import core.model.EntryPage;
/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface RightService {
	/**
	 *@更新或保存权限 
	 */
	public void saveOrUpdate(Right model);
	
	public void delete(Right model);
	
	public EntryPage query(int page, int size);
	
	public Right get(Integer id);
}
