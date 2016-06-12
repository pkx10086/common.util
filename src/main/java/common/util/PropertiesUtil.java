package common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 功能描述：Properties 工具类
 * @author pankx
 * @date 2016年5月30日
 */
public class PropertiesUtil {
	
	private static  PropertiesUtil propertiesUtil;
	private static InputStream inputStream  =null;
	 
	private PropertiesUtil(){
	
	}
	
	public static synchronized   PropertiesUtil getProperties(){
		try {
	    	  //inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("");
	    	  //inputStream = new FileInputStream(new File("src/main/resources/config.properties"));
	    	  //需要测试动态获取配置配件信息
			   inputStream = new FileInputStream(new File(Thread.currentThread().getContextClassLoader().getResource("").getFile()+"config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		if(propertiesUtil==null){
			  synchronized (PropertiesUtil.class) {  
			        if (propertiesUtil == null) {  
			        	propertiesUtil = new PropertiesUtil();  
			        }  
		   } 
		}
		
		return propertiesUtil;
	}
	
	
	public  String readValueBykey(String key){
		Properties props=new Properties();
		try {
			props.load(inputStream);
			return props.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static void main(String args[]){
		
	
//		System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getFile()+"config.properties");
	//	System.out.println(ClassLoader.getSystemResource(""));
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(PropertiesUtil.class.getClassLoader().getResourceAsStream("main/resources/config.properties"));//.getgetResourceAsStream("src/main/resources/config.properties"));
	  // System.out.println("[value]"+PropertiesUtil.readValueBykey("quarzt.schedule.time"));
	}
}
