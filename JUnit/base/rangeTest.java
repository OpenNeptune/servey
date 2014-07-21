package base;

import org.junit.Test;

public class rangeTest {
	@Test
	public void range(){
		//测试Integer和Long类型的数据大小范围
		System.out.println("Integer:"+Integer.MIN_VALUE+"<>"+Integer.MAX_VALUE);
		System.out.println("Long:"+Long.MIN_VALUE+"<>"+Long.MAX_VALUE);
	}
}
