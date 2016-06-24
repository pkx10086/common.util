package common.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.CharUtils;

/**
* 类说明：对象工具类
* @author pankx
* @date 2016年6月23日 下午4:37:43
*/
public class ObjectUtil {
	/**
	 * 功能描述：判断字符串是否为空
	 * @author pankx
	 * @date 2016年6月23日 下午4:40:55
	 * @param @param obj
	 * @param @return 
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj){
	if(obj==null || "".equals(obj.toString().trim())|| "null".equals(obj.toString().trim())){
		return true;
	}else{
		return false;
		
		}
	}
	
	/**
	 * 功能描述：判断对象是否为空
	 * @author pankx
	 * @date 2016年6月23日 下午5:02:59
	 * @param @param obj
	 * @param @return 
	 * @return boolean
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isObjEmpty(Object obj){
	
	if(obj==null){
		return true;
	}
	if(obj instanceof CharSequence){
		System.out.println(((CharSequence) obj).length());
		return ((CharSequence) obj).length()==0;
	}
	if(obj instanceof Map) {
		return ((Map) obj).isEmpty();
	}	
	
	if(obj instanceof String){
		return isEmpty(obj);
	}
	if(obj instanceof Collection){
		return ((Collection) obj).isEmpty();
	}
	if(obj instanceof Object[]){
		//return ((String) obj).length() <=0;
		return Array.getLength(obj)==0;
	}
	return false;
	}
	
	/**
	 * 功能描述：判断对象不为空
	 * @author pankx
	 * @date 2016年6月23日 下午5:26:53
	 * @param @param obj
	 * @param @return 
	 * @return boolean
	 */
	public static boolean isNotObjectEmpty(Object obj){
		return !isObjEmpty(obj);
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
}
