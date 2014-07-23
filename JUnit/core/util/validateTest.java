package core.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class validateTest {
	@Test
	public void listTest(){
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(validate.isValid(list));
		list.add(1);
		System.out.println(validate.isValid(list));
	}
}
