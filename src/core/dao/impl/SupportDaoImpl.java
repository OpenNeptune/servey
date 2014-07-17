package core.dao.impl;
/******************************************************************
 * @summary:
 * 		用于完成DAO操作的抽象基类，主要用于继承
 ******************************************************************/
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import core.dao.SupportDao;
import core.model.EntryPage;


public abstract class SupportDaoImpl<T>  implements SupportDao<T> {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//构造时初始（获取泛型）
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public SupportDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	public void saveEntry(T t) {
		hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		hibernateTemplate.update(t);
	}

	public void saveOrUpdateEntry(T t) {
		hibernateTemplate.saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	public int batchByHQL(String hql, Object... objects) {
		 List<T> list = (List<T>) hibernateTemplate.find(hql,objects);
		return list.size();
	}

	public void deleteEntryById(T t) {
		hibernateTemplate.delete(t);
	}

	public T loadEntry(String id) {
		return hibernateTemplate.load(clazz, id);
	}

	public T getEntry(String id) {
		return hibernateTemplate.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntryListByHQL(String hql,Object ...objects) {
		List<T> list = (List<T>) hibernateTemplate.find(hql,objects);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntryListBySQL(String sql,Object ...objects) {
		//如果没有开启事务管理，在线程中不允许获取session
		SQLQuery q =  hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		//添加实体类
		if(clazz != null){
			q.addEntity(clazz);
		}
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByHQL(String hql, Object[] objects) {
		return (List<T>) hibernateTemplate.find(hql,objects);
	}
	
	/**
	 * page默认值为1. 从第一页开始
	 * size默认值为100,每页100条记录
	 */
	@SuppressWarnings({ "unchecked", "deprecation","rawtypes" })
	public EntryPage query(final String hql, int page, final int size) {
		final EntryPage pageInfo = new EntryPage();
		pageInfo.setPageSize(size);
		pageInfo.setCurrentPage(page);
		pageInfo.setAllRow(hibernateTemplate.find(hql).size());
		pageInfo.init();
		List<Object> list = (List<Object>) getHibernateTemplate().executeFind(new HibernateCallback(){
	            public Object doInHibernate(Session session) throws HibernateException,SQLException{
	                Query query = session.createQuery(hql);
	                query.setFirstResult(pageInfo.getOffset());
	                query.setMaxResults(size);
					List list = query.list();
	                return list;
	            }
	    });
		pageInfo.setList(list);
		pageInfo.init();
		return pageInfo;
	}
}
