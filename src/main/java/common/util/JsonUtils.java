package common.util;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;

/**
* 类说明：jsonUtils
* @author pankx
* @date 2016年7月6日 下午4:38:52
*/
public class JsonUtils {
	
	/**
	 * 功能描述：fastJSon 将json 字符串转换为Object对象
	 * @author pankx
	 * @date 2016年7月6日 下午5:37:59
	 * @param @param json
	 * @param @param obj
	 * @param @param key
	 * @param @return 
	 * @return T
	 */
	public static <T> T objToJson(String json,Class<T> clazz,String key){
		
		if(StringUtils.isBlank(json)){
			return null;
		}
		
		T object =null;
		try{
			JSONObject jsonObject = JSONObject.parseObject(json);
			if(StringUtils.isBlank(key)){
				object=objToJson(json,clazz);
			}
			 object = jsonObject.getObject(key,clazz);
		}catch(Exception e){
			
		}	
	 return  object;
	}

	
	/**
	 * 功能描述：将json字符串转换为json对象
	 * @author pankx
	 * @date 2016年7月6日 下午5:31:08
	 * @param @param json
	 * @param @param obj
	 * @param @return 
	 * @return T
	 */
	public static<T> T objToJson(String json,Class<T> clazz){
		
		if(StringUtils.isBlank(json)){
			return null;
		}
		T t =null;
		try{
			
			JSONObject jsonObject = JSONObject.parseObject(json);
			t = TypeUtils.castToJavaBean(jsonObject, clazz);
		}catch(Exception e){
			
		}
		 return  t;
	}
	
	
	
	
	public static void main(String[] args) {
	/*	User user = new User();
		user.setName("小明");
		user.setAge(12);
		JSONObject json = new JSONObject();
		@SuppressWarnings("static-access")
		String str=json.toJSONString(user);
		System.out.println(str);
		User u = objToJson(str,user.getClass());
		System.out.println(u.getName());*/
		
		
	}
}

/*class User {
	private String id;
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
}*/