package common.util;
/**
* ��˵�����ַ���������
* @author pankx
* @date 2016��5��18�� ����10:03:01
*/
public class StringUtil {
	
	/**
	 * �����������ַ����Ƿ�Ϊ��
	 * @author pankx
	 * @date 2016��5��19�� ����10:36:14
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
