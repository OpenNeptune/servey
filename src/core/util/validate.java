package core.util;

import java.util.Collection;

public class validate {
	
	/**
	 * 判断字符串有效性
	 */
	public static boolean isValid(String src){
		return !(src == null || "".equals(src.trim()));
	}
	
	/**
	 * 判断集合的有效性 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection col){
		return !(col == null || col.isEmpty());
	}
	
	/**
	 * 判断数组是否有效
	 */
	public static boolean isValid(Object[] arr){
		return !(arr==null || arr.length==0);
	}
}
