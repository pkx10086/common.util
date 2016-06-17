package common.util;

import java.util.ArrayList;
import java.util.List;

/**
* 字符串工具类
* @author pankx
* @date 
*/
public class StringUtil {
	
/**
 * 功能描述：字符串为空，不包含空串
 * @author pankx
 * @date 2016年6月17日 下午1:39:28
 * @param @param str
 * @param @return 
 * @return boolean
 */
	public static boolean isBlank(String str){
		
		if(str==null || str.length()<=0 ||str.trim().length()<=0){
			return true;
		}
		return false;
	}
	
	/**
	 * 功能描述：字符串不为空返回true
	 * @author pankx
	 * @date 2016年6月17日 下午1:43:15
	 * @param @param str
	 * @param @return 
	 * @return boolean
	 */
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
	/**
	 * 功能描述：分隔字符串为数组
	 * @author pankx
	 * @date 2016年6月15日 下午6:08:09
	 * @param @param str
	 * @param @param division
	 * @param @return 
	 * @return String[]
	 */
	public static String[] split(String str,String division){

		if(isBlank(str)){
			return null;
		}
		
		if(isBlank(division)){
			return new String[]{str};
		}
		int index;
		List<String> slist = new ArrayList<String>();
		while((index=str.indexOf(division))!=-1){
			   slist.add(str.substring(0,index));
			   str=str.substring(index+division.length());
		}
		return  (String[])slist.toArray(new String[0]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String str_="sss,sss,Uuuu";
		String str[]=split(",sss,uuu,rrr,", ",");
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
			
		}
	}
}
