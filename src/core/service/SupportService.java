package core.service;

import java.util.List;

import core.model.EntryPage;

public interface SupportService<T> {
	//业务层的操作
	public void saveEntry(T t);
	
	public void updateEntry(T t);
	
	public void saveOrUpdateEntry(T t);
	
	public int batchByHQL(String hql,Object ...objects);
	
	public void deleteEntryById(T t);
	
	public T loadEntry(String id);
	
	public T getEntry(String id);
	
	public List<T> getEntryListByHQL(String hql,Object ...objects);
	
	public List<T> getEntryListBySQL(String sql,Object ...objects);
	
	public EntryPage query(final String hql, int page, final int size);
}
