package app.dao;


import org.junit.Test;

public class UserDaoTest extends app.Test{

	@Test
	public void test() {
		UserDao userDao = (UserDao) Context.getBean("userDao");
		System.out.println(userDao);
	}
	
	

}
