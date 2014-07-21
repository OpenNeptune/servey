package core.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class validateTest {
	@Test
	public void listTest(){
		List list = new ArrayList();
		System.out.println(validate.isValid(list));
		list.add(1);
		System.out.println(validate.isValid(list));
	}
}
