package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import common.util.StringUtil;

/**
* 类说明：
* @author pankx
* @date 2016年5月21日 上午10:13:57
*/
public abstract class DateAbstract {
	
	private static final String  FORMAL_DATE_DAY="yyyy-MM-DD";
	/**
	 * 功能描述：获得那天后的日期
	 * @author pankx
	 * @date 2016年5月21日 上午10:17:21
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
	 * 功能描述：日期格式化转换，将字符串的日期转换为日期格式
	 * @author pankx
	 * @date 2016年5月21日 上午10:35:43
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
	 * 功能描述：格式化日期，将字符串格式化为日期类型
	 * @author pankx
	 * @date 2016年5月21日 上午10:40:24
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