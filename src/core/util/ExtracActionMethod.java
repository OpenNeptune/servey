package core.util;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;

import app.service.RightService;

public class ExtracActionMethod {
	
	
	/**
	 * 通过读取所有的action类，通过反射获取到所有的action方法，
	 * 然后拼接成功能URI
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public static void extract(String dirs,RightService rs) throws Exception{
		ClassLoader loader = ExtracActionMethod.class.getClassLoader();
		URL url = loader.getResource(dirs);
		File dir = new File(url.toURI());
		File[] files = dir.listFiles();
		String fname = "" ;
		String regex = "(/)|(\\\\)";
		String pkgName = dirs.replaceAll(regex, "\\.") ;
		for(File f : files){
			fname = f.getName();
			if(fname.endsWith(".class") && !fname.equals("SupportAction.class")){
				try {
					String simpleClassName = fname.substring(0, fname.indexOf(".class"));
					String className = pkgName  + "." + simpleClassName ;
					//System.out.println(className);
					//得到具体类
					Class clazz = Class.forName(className);
					Method[] methods = clazz.getDeclaredMethods();
					Class retType = null ;
					String mname = null ;
					Class[] paramType = null ;
					String url2 = null ;
					for(Method m : methods){
						retType = m.getReturnType();//返回值类型
						mname = m.getName();        //方法名称
						paramType = m.getParameterTypes();//参数类型
						if(retType == String.class && !validate.isValid(paramType) && Modifier.isPublic(m.getModifiers())){
							/**
							 * 因为项目中统一使用exec_方法命名action方法并且Action不带Action后缀，且为小写
							 */
							if(mname.equals("execute")){
								url2 = "/" + simpleClassName.replace("Action", "").toLowerCase() ;
							}
							else if(mname.startsWith("exec_")){
								url2 = "/" + simpleClassName.replace("Action", "").toLowerCase() + "_" + mname.replace("exec_", "") ;
							}else{
								
							}
							rs.appendRightByURL(url2);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


}
