package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
* 类说明：日期工具�?
* @author pankx
* @date 2016�?�?1�?上午11:14:41
*/
public class DateUtil extends DateUtils {

	public static final String FORMAT_DATE_DAY="yyyy-MM-dd";
	public static final String FORMAT_DATE_SECOND="yyyy-MM-dd HH:mm:ss";

	
	/**
	 * 功能描述：将字符串类型的日期转换为日期类�?
	 * @author pankx
	 * @date 2016�?�?1�?下午2:28:55
	 * @param @param date
	 * @param @param pattern
	 * @param @return 
	 * @return Date
	 */
	public static Date parse(String date,String pattern){
		
		if(StringUtils.isBlank(pattern)){
			pattern=FORMAT_DATE_SECOND;
		}
		
		if(StringUtils.isNotBlank(date)){
			
			try {
				return parseDate(date, pattern);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * 功能描述：将日期转换为字符串
	 * @author pankx
	 * @date 2016�?�?1�?上午11:18:32
	 * @param @param date 
	 * @return void
	 */
	public static String DateToStr(Date date,String pattern){

		if(date==null){
			return null;
		}
		
		if(StringUtils.isBlank(pattern)){
			pattern = FORMAT_DATE_SECOND;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
		
	}
	
	/**
	 * 功能描述：将日期转换为字符串，默认是时分�?
	 * @author pankx
	 * @date 2016�?�?1�?上午11:18:32
	 * @param @param date 
	 * @return void
	 */
	public static String DateToStr(Date date){
		return DateToStr(date,"");
	}
	
	/**
	 * 功能描述：某个日期加上某些天返回字符串类型的日期
	 * @author pankx
	 * @date 2016�?�?1�?上午11:25:49
	 * @param @param date
	 * @param @param mount
	 * @param @return 
	 * @return String
	 */
	public static String dateAddDay(String date,int amount){
		
		if(StringUtils.isBlank(date)){
			return null;
		}
		
		Date _date = addDays(parse(date,FORMAT_DATE_SECOND), amount);
		return DateToStr(_date);

	}
	
	/**
	 * 功能描述�?n个月后的第一天的起始时间,负数是前几个月月初的起始时间,0是当前月的开始日�?
	 * @author pankx
	 * @date 2016�?�?1�?上午11:52:17
	 * @param @param date
	 * @param @param amount
	 * @param @return 
	 * @return String
	 */
	public static String getMonthFirstDate(Date date,int amount){
		
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_DAY);
		if(date==null){
			date = new Date();
		}
		
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, amount);
			cal.set(Calendar.DAY_OF_MONTH,1);
			return sdf.format(cal.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * 功能描述：下个月的月初开始日�?
	 * @author pankx
	 * @date 2016�?�?1�?下午2:18:26
	 * @param @return 
	 * @return String
	 */
	public static String afterMonthFirstDate(){
		return getMonthFirstDate(new Date(),1);
	}
	
	/**
	 * 功能描述：上个月的月初起始日�?
	 * @author pankx
	 * @date 2016�?�?1�?下午2:19:37
	 * @param @return 
	 * @return String
	 */
	public static String beforeMonthFirstDate(){
		return getMonthFirstDate(new Date(),-1);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(dateAddDay("2016-05-21 16:24:22",1));
	}
	
	
}
