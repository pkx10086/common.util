package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* 类说明：
* @author pankx
* @date 2016年5月26日 下午4:21:08
*/
public class TestCollections {

	public static void main(String args[]){
		Person p3= new Person();
		p3.setId(2);
		p3.setName("id");
		Person p1= new Person();
		p1.setId(1);
		p1.setName("id");
		
		Person p2= new Person();
		p2.setId(3);
		p2.setName("22id");
		
		
		
	List<Person> p = new ArrayList<Person>();
	p.add(p1);
	p.add(p2);
	p.add(p3);
	
	Collections.sort(p, new Comparator<Person>() {

		@Override
		public int compare(Person o1, Person o2) {
		  if(o1.getId()>o2.getId()){
			  return -1;
		  }else if(o1.getId()==o2.getId()){
			  return 0;
		  }else{
			  return 1;
		  }
		}
	});
	
	for(Person _p:p){
		System.out.println(">>>>>>>>>>>>>.."+_p.getId());
	}
	}
	
}


	class Person{
	
	private int id ;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	}
