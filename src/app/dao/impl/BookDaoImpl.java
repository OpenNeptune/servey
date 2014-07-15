package app.dao.impl;

import org.springframework.stereotype.Repository;

import app.dao.BookDao;
import app.model.Book;
import core.dao.impl.SupportDaoImpl;

@Repository("bookDao")
public class BookDaoImpl extends SupportDaoImpl<Book> implements BookDao {


}
