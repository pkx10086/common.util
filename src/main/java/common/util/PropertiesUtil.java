package common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
* ��˵������ȡ��׺Ϊ.properties�ļ��Ĺ�����
* @author pankx
* @date 2016��5��25�� ����2:51:05
*/
public class PropertiesUtil {
	private static InputStream inputStream  =null;
	
	static{
		try {
			inputStream = new FileInputStream(new File("src/main/resources/config.properties"));
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
		}
	
	}
	
	public static String readValueBykey(String key){
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
		
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(PropertiesUtil.class.getClassLoader().getResourceAsStream("main/resources/config.properties"));//.getgetResourceAsStream("src/main/resources/config.properties"));
		System.out.println("[value]"+PropertiesUtil.readValueBykey("quarzt.schedule.time"));
	}
}
