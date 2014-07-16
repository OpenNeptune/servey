package core.service;

import core.model.EntryPage;

public interface EntryPageService {
	public EntryPage query(String hql,int page,int size);
}
