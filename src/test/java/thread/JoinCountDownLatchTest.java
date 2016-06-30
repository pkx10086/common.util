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
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.omg.Messaging.SyncScopeHelper;

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
		//joinCountDownLatchTest.countDownLatchUse();
		//两个线程交换数据
		//joinCountDownLatchTest.exchangeData();
		//线程控制流量
		joinCountDownLatchTest.semaphore(30,5);
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
	
	
	/**Exchanger可以用于遗传算法，遗传算法里需要选出两个人作为交配对象，这时候会交换两人的数据，
	 * 并使用交叉规则得出2个交配结果。Exchanger也可以用于校对工作。比如我们需要将纸制银流通过人
	 * 工的方式录入成电子银行流水，为了避免错误，采用AB岗两人进行录入，录入到Excel之后，系统需要
	 * 加载这两个Excel，并对这两个Excel数据进行校对，看看是否录入的一致。代码如下：
	 * 功能描述：两个线程进行数据交换的Exchanger
	 * @author pankx
	 * @date 2016年6月27日 下午1:21:24
	 * @param  
	 * @return void
	 */
	public void exchangeData(){
		
        final Exchanger<String> ex = new Exchanger<String>();
	    ExecutorService threadPool = Executors.newScheduledThreadPool(2);
        //单个线程
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String A="银行流水A";
				try {
					String B=ex.exchange(A,10000, TimeUnit.MILLISECONDS);
					  System.out.println("["+Thread.currentThread().getName()+"]A和B数据是否一致：" + A.equals(B) + ",A录入的是："
	                            + A + ",B录入是：" + B);
				} catch (InterruptedException | TimeoutException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				String B ="银行流水B";// TODO Auto-generated method stub
				try {
					   String A=ex.exchange(B,10000, TimeUnit.MILLISECONDS);
					   System.out.println("["+Thread.currentThread().getName()+"]A和B数据是否一致：" + A.equals(B) + ",A录入的是："
                            + A + ",B录入是：" + B);
				} catch (InterruptedException | TimeoutException e) {
					e.printStackTrace();
				}
			}
		}).start();
		//线程池
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				String C ="银行流水C";// TODO Auto-generated method stub
				try {
					   String D=ex.exchange(C,10000, TimeUnit.MILLISECONDS);
					   System.out.println("["+Thread.currentThread().getName()+"]C和D数据是否一致：" + C.equals(D) + ",C录入的是："
                            + C + ",D录入是：" + D);
				} catch (InterruptedException | TimeoutException e) {
					e.printStackTrace();
				}
			}
		});
		
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				String D ="银行流水C";// TODO Auto-generated method stub
				try {
					   String C=ex.exchange(D,10000, TimeUnit.MILLISECONDS);
					   System.out.println("["+Thread.currentThread().getName()+"]C和D数据是否一致：" +C.equals(D) + ",C录入的是："
                            +C+ ",D录入是：" + D);
				} catch (InterruptedException | TimeoutException e) {
					e.printStackTrace();
				}
			}
		});
		
		  //线程池 测试线程池的名字
				threadPool.execute(new Runnable() {
					@Override
					public void run() {
						String E ="银行流水E";// TODO Auto-generated method stub
						try {
							   String F=ex.exchange(E,10000, TimeUnit.MILLISECONDS);
							   System.out.println("["+Thread.currentThread().getName()+"]E和F数据是否一致：" + E.equals(F) + ",E录入的是："
		                            + E + ",F录入是：" + F);
						} catch (InterruptedException | TimeoutException e) {
							e.printStackTrace();
						}
					}
				});
				
				threadPool.execute(new Runnable() {
					@Override
					public void run() {
						String F ="银行流水F";// TODO Auto-generated method stub
						try {
							   String E=ex.exchange(F,10000, TimeUnit.MILLISECONDS);
							   System.out.println("["+Thread.currentThread().getName()+"]E和F数据是否一致：" + E.equals(F) + ",E录入的是："
			                            + E + ",F录入是：" + F);
						} catch (InterruptedException | TimeoutException e) {
							e.printStackTrace();
						}
					}
				});
	}
	
	/**
	 * Semaphore可以用于做流量控制，特别公用资源有限的应用场景，比如数据库连接。
	 * 假如有一个需求，要读取几万个文件的数据，因为都是IO密集型任务，我们可以启
	 * 动几十个线程并发的读取，但是如果读到内存后，还需要存储到数据库中，而数据库
	 * 的连接数只有10个，这时我们必须控制只有十个线程同时获取数据库连接保存数据，
	 * 否则会报错无法获取数据库连接。这个时候，我们就可以使用Semaphore来做流控，
	 * 代码如下：
	 * 功能描述：控制并发线程数的Semaphore
	 * @author pankx
	 * @date 2016年6月27日 下午2:01:27
	 * @param  
	 * @return void
	 * 
	 * 在代码中，虽然有30个线程在执行，但是只允许10个并发的执行。
	 * Semaphore的构造方法Semaphore(int permits) 接受一个整型的数字，
	 * 表示可用的许可证数量。Semaphore(10)表示允许10个线程获取许可证，
	 * 也就是最大并发数是10。Semaphore的用法也很简单，首先线程使用
	 * Semaphore的acquire()获取一个许可证，使用完之后调用release()归还许可证。
	 * 还可以用tryAcquire()方法尝试获取许可证。
	 */
	public void semaphore(int threadCount,int activeThreadCount){
		//threadCount,线程数量
		//activeThreadCount 控制线程执行数量 activeThreadCount<threadCount
		 ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
		 final Semaphore s = new Semaphore(activeThreadCount); //活动线程10个
		 
		 for(int i=0;i<threadCount;i++){
			 
			 threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println("["+Thread.currentThread().getName()+"] 执行保存save操作[time]"+System.currentTimeMillis());
						s.release(); //注释掉可以看到的确同步执行数量activeThreadCount个
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			});
		 }
		 threadPool.shutdown();
	}
	
	
	
}
