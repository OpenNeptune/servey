package app.struts.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.Book;
import app.model.User;
import app.service.TransactionTestService;

import com.opensymphony.xwork2.ActionSupport;

import core.util.sec;

@Controller("transactionAction")
@Scope("prototype")
public class transactionAction extends ActionSupport {

	private static final long serialVersionUID = 7751604972083199971L;
	
	@Resource(name="transactionTestService")
	private TransactionTestService transaction;
	
	private User user;
	
	private Book book;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String exec_save(){
		user.setEmail("111@com.com");
		user.setPassword(sec.md5("1111"));
		System.out.println(user+"\n"+book);
		transaction.save(user, book);
		return SUCCESS;
	}
}
