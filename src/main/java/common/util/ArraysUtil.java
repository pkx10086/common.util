package common.util;
/**
* 数组对象工具类
* @author pankx
* @date 2016-06-06 13:37
*/
public class ArraysUtil {

	/**
	 * 判断数组对是否为空
	 * @author pankx
	 * @date @date 2016-06-06 13:37
	 * @param @param array
	 * @param @return 
	 * @return boolean
	 */
	public static boolean isEmpty(Object []array){
		
		if(array==null || array.length<=0){
			return true;
		}
		return false;
	}
	
	/**
	 * ������������¡����
	 * @author pankx
	 * @date 2016��5��18�� ����10:17:32
	 * @param @param obj
	 * @param @return 
	 * @return T[]
	 */
	public static <T> T[] clone(Object []array){
		if(array==null ){
			return null;
		}

		@SuppressWarnings("unchecked")
		T[] clone = (T[]) array.clone();
		return clone;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Person str[]=new Person[2];
		Person person = new Person();
		person.setAge(11);
		person.setName("xiaohong");
		str[0]=person;
		Person person2 = new Person();
		person2.setAge(21);
		person2.setName("xiaohong");
		str[1]=person2;
		Object []p = clone(str);
		Person pp[]=(Person[])p[0];
		System.out.println(pp[0].getName());
	}
	
}


class Person{
	
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
