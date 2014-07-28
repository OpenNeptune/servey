package app.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import app.model.User;
import app.service.UserService;
import core.model.EntryPage;
import core.service.impl.SupportServiceImpl;
import core.util.sec;
import core.util.validate;

@Service("userService")
public class UserServiceImpl extends SupportServiceImpl<User> implements UserService{

	@Override
	public boolean isRegisterByName(String username) {
		String hql = "from User u where u.username = ?" ;
		List<User> list = this.findByHQL(hql, username);
		return !validate.isValid(list) ;
	}

	@Override
	public boolean isRegisterByEmail(String email) {
		String hql = "from User u where u.email = ?" ;
		List<User> list = this.findByHQL(hql, email);
		return !validate.isValid(list) ;
	}

	@Override
	public User login(User user) {
		String hql = "from User u where u.username = ? and u.password = ?" ;
		List<User> list = this.findByHQL(hql,user.getUsername(),sec.md5(user.getPassword()));
		return validate.isValid(list)?list.get(0):null;
	}

	@Override
	public EntryPage query(int currentPage, int pageSize) {
		String hql ="from User u order by u.userid desc";
		return super.query(hql, currentPage, pageSize);
	}

	

}
