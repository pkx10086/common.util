package common;
/**
* 类说明：
* @author pankx
* @date 2016年5月26日 下午6:46:31
*/
public class Test {

	
	public String testAdd(){
		System.out.println("2222222");
		_testAdd();
		System.out.println("333333");
		return "1";
	}
	
	
	public void _testAdd(){
		
		System.out.println("444444444444444");
		boolean flag =true;
		if(flag){
			return;
		}
		System.out.println("55555555555555");
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.testAdd());
	}
}
