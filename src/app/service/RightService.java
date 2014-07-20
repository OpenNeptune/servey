package app.service;

import app.model.Right;
import core.model.EntryPage;
/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface RightService {
	public void save(Right model);
	
	public void delete(Right model);
	
	public EntryPage query(int page, int size);
}
