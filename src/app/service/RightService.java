package app.service;

import java.util.Set;

import app.model.Right;
import core.model.EntryPage;
import core.service.SupportService;
/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface RightService extends SupportService<Right>{
	/**
	 *@更新或保存权限 
	 */
	
	
	public EntryPage query(int page, int size);
	
	
	/**
	 * 通过读取所有的action类，通过反射获取到所有的action方法，
	 * 然后拼接成功能URI
	 */
	public void refreshRight();

	/**
	 * 添加权限
	 * @param url
	 */
	public void appendRightByURL(String url);
	
	/**
	 * 通过一个权限ID数组，获取一个权限Set
	 */
	public Set<Right> getByArray(String[] rightId);

	
	/**
	 * 获得权限的最大分组
	 */
	public int getMaxRightPos();
}
