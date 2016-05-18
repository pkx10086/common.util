package common_util;

import java.util.HashSet;

import org.junit.Test;

class Name{
	
	private String name;
	private int age;
	
	public Name(String name,int age) {
		this.name=name;
		this.age=age;
	}

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
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}

/**
* 类说明：
* @author pankx
* @date 2016年5月11日 下午5:04:12
*/

//@RunWith(SpringJUnit4ClassRunner.class)
public class JunitTest {
	
	@Test
	public void testCollection(){
		
		Name n1 = new Name("xiaoming",20);
		Name n2 = new Name("xiaoming",20);
		System.out.println(n1.hashCode());
		System.out.println(n2.hashCode());
		
		HashSet<Name> hset = new HashSet<Name>();
		hset.add(n1);
		hset.add(n2);
		System.out.println(hset);
		System.out.println(1^2);
	}

}
