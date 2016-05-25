package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import common.util.StringUtil;

/**
* ��˵����
* @author pankx
* @date 2016��5��21�� ����10:13:57
*/
public abstract class DateAbstract {
	
	private static final String  FORMAL_DATE_DAY="yyyy-MM-DD";
	/**
	 * �����������������������
	 * @author pankx
	 * @date 2016��5��21�� ����10:17:21
	 * @param @param date
	 * @param @param n
	 * @param @return 
	 * @return Date
	 */
	public Date dateAddDay(String date,int n){
		if(StringUtil.isBlank(date)){
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatDate(date));
		cal.add(Calendar.DATE,n);
		return cal.getTime();
		
	}
	
	/**
	 * �������������ڸ�ʽ��ת�������ַ���������ת��Ϊ���ڸ�ʽ
	 * @author pankx
	 * @date 2016��5��21�� ����10:35:43
	 * @param @param date
	 * @param @return 
	 * @return Date
	 */
	public Date formatDateToday(String date){
		if(StringUtil.isBlank(date))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(FORMAL_DATE_DAY);
		
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * ������������ʽ�����ڣ����ַ�����ʽ��Ϊ��������
	 * @author pankx
	 * @date 2016��5��21�� ����10:40:24
	 * @param @param date
	 * @param @return 
	 * @return Date
	 */
	public Date formatDate(String date){
		if(StringUtil.isBlank(date))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(date);
		
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}