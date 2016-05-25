package common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.lang3.ClassPathUtils;
import org.junit.runner.Request;

/**
* 类说明：读取后缀为.properties文件的工具类
* @author pankx
* @date 2016年5月25日 下午2:51:05
*/
public class PropertiesUtil {
	static String path =System.getenv("user.dir")+"/";
	static{
		
	}
	
	
	public PropertiesUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static String readValueBykey(String key){
		 InputStream inputStream;
		 Properties props=new Properties();
		try {
			inputStream = new FileInputStream(path);
			props.load(inputStream);
			return props.getProperty(key);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[]){
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(PropertiesUtil.class.getClassLoader().getResourceAsStream("main/resources/config.properties"));//.getgetResourceAsStream("src/main/resources/config.properties"));
		//System.out.println("[value]"+PropertiesUtil.readValueBykey("quarzt.schedule.time"));
	}
}
