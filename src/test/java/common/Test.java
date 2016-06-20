package common;
/**
* 类说明：
* @author pankx
* @date 2016年5月26日 下午6:46:31
*/
public class Test{
	
	 String msg = "";
	public void testAdd_(){
		System.out.println("************");
	    	msg="222";
	    	if(msg.equals("333")){
	    		System.out.println("msg:"+msg);
	    	}
		System.out.println("*****************");
		
	}
	
	
	public void _testAdd(){
		
		System.out.println("###################");
		msg="333";
		if(msg.equals("222")){
    		System.out.println("msg3:"+msg);
    	}
		System.out.println("##################");
	}

	public static void main(String[] args) {
		
	
		for(int i=0;i<1000;i++){
			new Thread(new Runnable() {
			   Test t = new Test();
				@Override
				public void run() {
					t._testAdd();
					t.testAdd_();
				}
			}).start();
			
		}
	}
}
