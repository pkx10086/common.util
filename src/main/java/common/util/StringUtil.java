package common.util;
/**
* 类说明：字符串工具类
* @author pankx
* @date 2016年5月18日 上午10:03:01
*/
public class StringUtil {
	
	/**
	 * 功能描述：字符串是否为空
	 * @author pankx
	 * @date 2016年5月19日 上午10:36:14
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
	
	public static void main(String[] args) {
	}
}
