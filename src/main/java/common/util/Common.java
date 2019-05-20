package common.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Common {
	protected Logger log = LoggerFactory.getLogger(getClass());
	private static Common common;

	/**
	 * 单例模式
	 * 
	 * @return
	 */
	public static Common getInstance() {
		if (common == null) {
			common = new Common();
		}

		return common;
	}

	/**
	 * 将实体对象转化为Map**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map putDataByEntity(Object entity) throws Exception {
		Map data = new HashMap();
		Method[] methods = entity.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			String methodName = methods[i].getName();
			if (methodName.startsWith("get")) {
				String paramName = methodName.substring(3, methodName.length());
				data.put(paramName, methods[i].invoke(entity, null));
			}
		}
		return data;
	}

	/**
	 * 去掉字符串前缀
	 * 
	 * @param str
	 * @param prefix
	 * @return
	 */
	public String trimPrefix(String str, String prefix) {
		return str.startsWith(prefix) ? str.substring(prefix.length()) : str;
	}

	/**
	 * 去掉后缀
	 * 
	 * @param str
	 * @param suffix
	 * @return
	 */
	public String trimSuffix(String str, String suffix) {
		return str.endsWith(suffix) ? str.substring(0, suffix.length() - 1) : str;
	}

	/**
	 * 将数组转化为以逗号(,)分割开的字符串
	 * 
	 * @param array
	 * @return
	 */
	public String getStrByArray(String[] array) {
		return getStrByArray(array, ",");
	}

	/**
	 * 将数组转转为字符串
	 * 
	 * @param array
	 * @return
	 */
	public String getStrByArray(String[] array, String split) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			str.append(array[i] + (i != array.length - 1 ? split : ""));
		}
		return str.toString();
	}

	public String encodeCharset(String charSet) {
		String set = null;
		try {
			set = new String(charSet.getBytes("GBK"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return set;
	}

	public String decodeCharset(String charSet) {
		String set = null;
		try {
			set = new String(charSet.getBytes("ISO8859_1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return set;
	}

	/**
	 * 字符串格式
	 * 
	 * @param value
	 * @return
	 */
	public String getTimestampFormat(String value) {
		switch (value.length()) {
		case 4:
			return "yyyy";
		case 6:
			return "yyyyMM";
		case 7:
			return "yyyy-MM";
		case 8:
			return "yyyyMMdd";
		case 10:
			return "yyyy-MM-dd";
		case 13:
			return "yyyy-MM-dd HH";
		case 16:
			return "yyyy-MM-dd HH:mm";
		case 19:
			return "yyyy-MM-dd HH:mm:ss";
		case 21:
			return "yyyy-MM-dd HH:mm:ss.S";
		}
		return null;
	}

	public Date encodeTimestamp(String timeStr) {
		if ((timeStr == null) || ("".equals(timeStr))) {
			return null;
		}
		String format = getTimestampFormat(timeStr);
		if (StringUtils.isEmpty(format)) {
			return null;
		}
		return encodeTimestamp(format, timeStr);
	}

	public Date encodeTimestamp(String format, String timeStr) {
		if ((timeStr == null) || ("".equals(timeStr))) {
			return null;
		}
		Date date = null;
		if ((null == timeStr) || ("".equals(timeStr))) {
			return null;
		}
		if (format.length() != timeStr.length()) {
			format = getTimestampFormat(timeStr);
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = new Timestamp(sdf.parse(timeStr).getTime());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	public String decodeTimeStr(String format, String timeStr) {
		Date time = encodeTimestamp(format, timeStr);
		return decodeTimestamp(format, time);
	}

	public String decodeTimestamp(String format, Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(time);
	}

	public Date getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	public String getSysTime() {
		return decodeTimestamp("yyyy-MM-dd HH:mm:ss", new Timestamp(System.currentTimeMillis()));
	}

	public String getSysDate() {
		return decodeTimestamp("yyyy-MM-dd", new Timestamp(System.currentTimeMillis()));
	}

	public String getLastDay() {
		return getLastDay(getSysDate());
	}

	public String getLastDay(String timestr) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(encodeTimestamp(timestr));
		cal.set(5, cal.getActualMaximum(5));

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.format(cal.getTime());
	}

	public String getPrevDayByCurrDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(5, -1);

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.format(cal.getTime());
	}

	public String getPrevMonthFirstDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(2, -1);
		cal.set(5, 1);

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.format(cal.getTime());
	}

	public String formatDecimal(String format, double decimal) {
		DecimalFormat df = new DecimalFormat(format);
		return df.format(decimal);
	}

	public URL getClassResource(String file) {
		URL url = getClass().getClassLoader().getResource(file);
		if (url == null) {
			error("file " + file + " not exist!");
		}
		return url;
	}

	public Object putEntityByData(Object entity, Map data) throws Exception {
		Method[] methods = entity.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if (methodName.startsWith("set")) {
				Class methodType = method.getParameterTypes()[0];
				Object[] params = new Object[1];

				String paramName = methodName.substring(3, methodName.length()).toUpperCase();
				Object paramValue = data.get(paramName);
				if (paramValue != null) {
					params[0] = paramValue;
					if (String.class.isAssignableFrom(methodType)) {
						params[0] = paramValue;
					} else if (Date.class.isAssignableFrom(methodType)) {
						params[0] = encodeTimestamp((String) paramValue);
					} else if (Long.class.isAssignableFrom(methodType)) {
						params[0] = new Long(paramValue.toString());
					} else if (Integer.class.isAssignableFrom(methodType)) {
						params[0] = new Integer(paramValue.toString());
					} else if (Short.class.isAssignableFrom(methodType)) {
						params[0] = new Short(paramValue.toString());
					} else if (Double.class.isAssignableFrom(methodType)) {
						params[0] = new Double(paramValue.toString());
					} else if (Float.class.isAssignableFrom(methodType)) {
						params[0] = new Float(paramValue.toString());
					} else if (Boolean.class.isAssignableFrom(methodType)) {
						params[0] = new Boolean(paramValue.toString());
					}
					method.invoke(entity, params);
				}
			}
		}
		return entity;
	}

	public void error(String message) throws RuntimeException {
		RuntimeException exception = new RuntimeException(message);
		this.log.error(message);
		throw exception;
	}
	
	public Object reflectInvoke(Object bean, String funcName, Object[] params, Class[] types)
		    throws Exception
		  {
		    Object ret = null;
		    Class[] Params = new Class[params.length];
		    for (int i = 0; i < params.length; i++) {
		      if ((types != null) && (types[i] != null)) {
		        Params[i] = types[i];
		      } else if (params[i] != null) {
		        Params[i] = params[i].getClass();
		      }
		    }
		    Method method = bean.getClass().getMethod(funcName, Params);
		    
		    ret = method.invoke(bean, params);
		    
		    return ret;
		  }
	public static void main(String[] args) {
		Common comm = Common.getInstance();
		User user = new User();
		user.setAge(10);
		user.setId("1");
		user.setName("下坡");
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("ID","111");
		map.put("NAME", "小明");
		map.put("AGE", 10);
	}
}
