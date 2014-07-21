package app.service;

import org.junit.Test;

import app.model.Right;


public class RightServiceTest extends app.Test{

	@Test
	public void test() {
		
		RightService rightService =(RightService) Context.getBean("rightService");
		
		Right right = rightService.get(1279820);
		
		System.out.println(right);
	}

}
