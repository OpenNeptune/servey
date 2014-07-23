package app.service;

import app.model.User;
import core.service.SupportService;
/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface UserService extends SupportService<User> {
	
	//判断该用户名是否可以注册
	public boolean isRegisterByName(String username);
	
	//判断是否是一个可用的邮箱地址
	public boolean isRegisterByEmail(String emial);
	
	//用户登录
	public User login(User user);
	
	
}
