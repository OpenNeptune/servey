package core.service.impl;

import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import core.dao.SupportDao;
import core.model.EntryPage;
import core.service.SupportService;

public abstract class SupportServiceImpl<T> implements SupportService<T> {
	
		public Logger log = Logger.getLogger(this.getClass());
	
		@Autowired
		private SupportDao<T> supportDao;
		
		public void saveEntry(T t) {
			supportDao.saveEntry(t);
		}


		public SupportDao<T> getSupportDao() {
			return supportDao;
		}


		public void setSupportDao(SupportDao<T> supportDao) {
			this.supportDao = supportDao;
		}


		@Override
		public void updateEntry(T t) {
			supportDao.updateEntry(t);
		}

		@Override
		public void saveOrUpdateEntry(T t) {
			supportDao.saveOrUpdateEntry(t);
		}

		@Override
		public int batchByHQL(String hql, Object... objects) {
			return supportDao.batchByHQL(hql, objects);
		}

		@Override
		public void deleteEntryById(T t) {
			supportDao.deleteEntryById(t);
		}

		@Override
		public T loadEntry(String id) {
			return (T) supportDao.loadEntry(id);
		}

		@Override
		public T getEntry(String id) {
			return (T) supportDao.getEntry(id);
		}

		@Override
		public List<T> getEntryListByHQL(String hql, Object... objects) {
			return supportDao.getEntryListByHQL(hql, objects);
		}

		@Override
		public List<T> getEntryListBySQL(String sql, Object... objects) {
			return supportDao.getEntryListBySQL(sql, objects);
		}
		
		public List<T> findEntityByHQL(String hql, Object... objects) {
			return supportDao.findEntityByHQL(hql, objects);
		}

		public EntryPage query(final String hql, int page, final int size){
			return supportDao.query(hql, page, size);
		}
		
}
