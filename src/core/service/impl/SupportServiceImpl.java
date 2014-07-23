package core.service.impl;

import java.util.List;





import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import core.dao.SupportDao;
import core.model.EntryPage;
import core.service.SupportService;

public abstract class SupportServiceImpl<T> implements SupportService<T> {
	
		public  Logger log = Logger.getLogger(this.getClass());
	
		@Autowired
		@Getter @Setter private SupportDao<T> supportDao;
		
		public void save(T t) {
			supportDao.saveEntry(t);
		}


		@Override
		public void update(T t) {
			supportDao.updateEntry(t);
		}

		@Override
		public void saveOrUpdate(T t) {
			supportDao.saveOrUpdateEntry(t);
		}

		@Override
		public int batchByHQL(String hql, Object... objects) {
			return supportDao.batchByHQL(hql, objects);
		}

		@Override
		public void delete(T t) {
			supportDao.deleteEntryById(t);
		}

		@Override
		public T load(Integer id) {
			return (T) supportDao.loadEntry(id);
		}

		@Override
		public T get(Integer id) {
			return (T) supportDao.getEntry(id);
		}

		@Override
		public List<T> getListByHQL(String hql, Object... objects) {
			return supportDao.getEntryListByHQL(hql, objects);
		}

		@Override
		public List<T> getListBySQL(String sql, Object... objects) {
			return supportDao.getEntryListBySQL(sql, objects);
		}
		
		public List<T> findByHQL(String hql, Object... objects) {
			return supportDao.findEntityByHQL(hql, objects);
		}

		public EntryPage query(final String hql, int page, final int size){
			return supportDao.query(hql, page, size);
		}


		@Override
		public List<T> findAll() {
			return supportDao.findAll();
		}
		
		
}
