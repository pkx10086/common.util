package common;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import common.util.Exceptions;
import common.util.NetServiceException;

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
		int a=100;
	int b=0;


	try {
		int c=a/b;
	} catch (Exception e) {
		
		//e.printStackTrace();
		System.out.println("1:"+e.toString());
		System.out.println("2:"+e.getMessage());
		StackTraceElement[] sts= e.getStackTrace();
		StringBuilder stb= new StringBuilder();
		for(int i=0;i<sts.length;i++){
			stb.append(sts[i]);
		}
		System.out.println("5:"+stb.toString());
		System.out.println("3:"+e.getStackTrace());
		System.out.println("4:"+e.getLocalizedMessage());
		System.out.println("=======================");
		System.out.println("6:"+Exceptions.getStackTraceAsString(e));
		System.out.println("7:"+Exceptions.unchecked(e));
		System.out.println("8:"+Exceptions.isCausedBy(e,Exception.class));
		String str="nememmemememme";
		String str1="";
		System.out.println(str.format("username:%s",str));
		System.out.println(str1.copyValueOf(new char[]{'n','e','m','m'}));
		System.out.println(str1);
		
		
	}
		
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
