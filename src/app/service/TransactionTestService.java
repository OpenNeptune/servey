package app.service;

import app.model.Book;
import app.model.User;

/**
 * @summary:
 * 	测试事务 
 *
 */
public interface TransactionTestService {
	public void save(User user,Book book);
}
