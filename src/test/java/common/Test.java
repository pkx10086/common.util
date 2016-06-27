package common;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

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
		
	/*
		for(int i=0;i<1000;i++){
			new Thread(new Runnable() {
			   Test t = new Test();
				@Override
				public void run() {
					t._testAdd();
					t.testAdd_();
				}
			}).start();
			
		}*/
		
		
		/*System.out.println(new BigDecimal(15).multiply(new BigDecimal(0.05)));
		
		int arra[] = new int[]{1,2,3,3,4,5,};
		for(int i:arra){
			System.out.println(arra[i]);
		}
		
*/		
	/*	String str="ww";
		
		String st[] = str.split(",");
		
		
		if(StringUtils.isBlank(st[0])||StringUtils.isBlank(st[1])||StringUtils.isBlank(st[2])){
			
			System.out.println(st.toString());
		}*/
	}
}
