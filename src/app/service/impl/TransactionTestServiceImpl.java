package app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import app.dao.impl.BookDaoImpl;
import app.dao.impl.UserDaoImpl;
import app.model.Book;
import app.model.User;
import app.service.TransactionTestService;

@Service("transactionTestService")
public class TransactionTestServiceImpl implements TransactionTestService {

	@Resource(name="userDao")
	private UserDaoImpl userDao;
	
	@Resource(name="bookDao")
	private BookDaoImpl bookDao;
	
	@Override
	public void save(User user, Book book) {
		userDao.saveEntry(user);
		
		bookDao.saveEntry(book);
		throw new RuntimeException("出错了");
	}

}
