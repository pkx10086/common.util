package common.util;
/**
* ��˵�����ַ���������
* @author pankx
* @date 2016��5��18�� ����10:03:01
*/
public class StringUtil {

	public boolean isBlank(String str){
		
		if(str==null || str.length()<=0 ||str.trim().length()<=0){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
	}
}
