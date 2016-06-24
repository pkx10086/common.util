package thread;
/**
 * 简介

CountDownLatch 允许一个或多个线程等待其他线程完成操作。

应用场景

假如有这样一个需求，当我们需要解析一个Excel里多个sheet的数据时，
可以考虑使用多线程，每个线程解析一个sheet里的数据，
等到所有的sheet都解析完之后，程序需要提示解析完成。
在这个需求中，要实现主线程等待所有线程完成sheet的解析操作，
最简单的做法是使用join。代码如下
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* 类说明：
* @author pankx
* @date 2016年6月24日 上午9:48:17
*/
public class JoinCountDownLatchTest {
	public static void main(String[] args) {
		JoinCountDownLatchTest joinCountDownLatchTest = new JoinCountDownLatchTest(); 
		//线程等待，集合所有线程后操作
		//joinCountDownLatchTest.cyclicBarrierUse();
		 //等待线程
		joinCountDownLatchTest.countDownLatchUse();
	}
	
	/**
	 * 功能描述：* CountDownLatch： 
	 * 好比倒计时计数器，调用CountDownLatch对象的CountDown方法就将计数器减1，当计数器到达0时，则所有等待线程 
	 * 或单个等待线程开始执行。 
	 * @author pankx
	 * @date 2016年6月24日 下午1:45:31
	 * @param  
	 * @return void
	 */
	public void countDownLatchUse(){
		
		 ExecutorService service = Executors.newCachedThreadPool();  
	        // 创建两个计数器，cdOrder的初始值为1，cdAnswer初始值为3  
	        final CountDownLatch cdOrder = new CountDownLatch(1);  
	        final CountDownLatch cdAnswer = new CountDownLatch(3);        
	          
	        for(int i=0;i<3;i++){  
	            Runnable runnable = new Runnable(){  
	                    public void run(){  
	                    try {  
	                        System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");                          
	                        cdOrder.await(); // 所有的线程都在此等待，并希望被其他线程调用cdOrder.countDown()激活，在这里由主线程激活  
	                          
	                        System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");                                
	                        Thread.sleep((long)(Math.random()*10000));    
	                          
	                        System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");                         
	                        cdAnswer.countDown();// cdAnswer计数器的初始值为3，，三个线程到达后调用cdAnswer.countDown()到计数为0，激活主线程  
	                    } catch (Exception e) {  
	                        e.printStackTrace();  
	                    }                 
	                }  
	            };  
	            service.execute(runnable);  
	        }         
	          
	        try {  
	            Thread.sleep((long)(Math.random()*10000));  
	          
	            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");                       
	            cdOrder.countDown();// 主线程将cdOrder计数器减1  
	              
	            System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");     
	            cdAnswer.await();// 主线程正在等待，希望被其他线程激活  
	              
	            System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");    
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }                 
	        service.shutdown();  
	    }  
	/**
	 * CyclicBarrier
	 * 功能描述：表示线程彼此等待，等所有的线程都集合后，才开始做任务 
	 * @author pankx
	 * @date 2016年6月24日 下午12:27:01
	 * @param  
	 * @return void
	 */
	public void cyclicBarrierUse(){
		
		ExecutorService service = Executors.newCachedThreadPool();  
		 final  CyclicBarrier cb = new CyclicBarrier(3); //数量必须和线程数量一致
		 for(int i=0;i<3;i++){
			    Runnable runnable = new Runnable() {
			@Override
			public void run() {
				   try {
					Thread.sleep((long)(Math.random()*10000));
					System.out.println("[线程名字]"+Thread.currentThread().getName()+"即将到达集合点一，当前有几个线程到达"+cb.getNumberWaiting());
					cb.await();
					Thread.sleep((long)(Math.random()*10000));
					System.out.println("[线程名字]"+Thread.currentThread().getName()+"即将到达集合点二，当前有几个线程到达"+cb.getNumberWaiting());
					cb.await();
					Thread.sleep((long)(Math.random()*10000));
					System.out.println("[线程名字]"+Thread.currentThread().getName()+"即将到达集合点三，当前有几个线程到达"+cb.getNumberWaiting());
					cb.await();
				   } catch (Exception e) {
					e.printStackTrace();
				}   
			}
	  };
	  System.out.println("==========["+i+"]=======");
	  service.execute(runnable);
	}
		 service.shutdown();
	}
}
