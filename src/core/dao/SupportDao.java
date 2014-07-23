package core.dao;

import java.util.List;

import core.model.EntryPage;

public interface SupportDao<T> {
	
	//DAO层的API
	
	//保存实体
	public void saveEntry(T t);
	
	//更新实体
	public void updateEntry(T t);
	
	//保存或更新
	public void saveOrUpdateEntry(T t);
	
	//删除实体
	public void deleteEntryById(T t);
	
	//加载实体
	public T loadEntry(Integer id);
	
	//加载实体
	public T getEntry(Integer id);
	
	//以HQL方式批量操作
	public int batchByHQL(String hql,Object ...objects);
	
	//通过HQL获得实体列表
	public List<T> getEntryListByHQL(String hql,Object ...objects);
	
	//通过SQL获得提示列表
	public List<T> getEntryListBySQL(String sql,Object ...objects);

	public List<T> findEntityByHQL(String hql, Object[] objects);
	
	//以分页的方式获得实体
	public EntryPage query(final String hql, int page, final int size);
	
	public List<T> findAll();
	
}
