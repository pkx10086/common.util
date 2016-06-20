package common_util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.DateAbstract;

/**
* ��˵����
* @author pankx
* @date 2016��5��21�� ����10:16:17
*/
public class Test extends DateAbstract {
	
	static String date ="2016-05-21 23:12";
	
	
	public static void main(String args[]){
		
		List<User> strs = new ArrayList<User>();
		User user = new User();
		user.setId(1L);
		user.setName("name");
		user.setAge(20);
		User user1 = new User();
		user1.setId(2L);
		user1.setName("name1");
		user1.setAge(20);
		User user2 = new User();
		user2.setId(1L);
		user2.setName("name");
		user2.setAge(20);
		strs.add(user);
		strs.add(user1);
		strs.add(user2);
		int i=0;
		for(User u:strs){
			
			if(i==1){
				strs.remove(u);
			}
			i++;
		}
		
		for(User  s:strs){
			System.out.println(s);
		}
	}

}
class User{
	
	private String name;
	private int age;
	private Long id;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	
	
}
