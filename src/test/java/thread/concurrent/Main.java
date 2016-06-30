package thread.concurrent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
* 类说明：
* @author pankx
* @date 2016年6月30日 下午4:03:01
*/
public class Main {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//创建ConcurrentLinkedDeque对象，并指定它的泛型参数是String型的。

		ConcurrentLinkedDeque list=new ConcurrentLinkedDeque();
		//11．创建线程数组threads，它包含100个线程。

		Thread threads[]=new Thread[100];
		//创建100个AddTask对象及其对应的运行线程。将每个线程存放到上一步创建的数组中，然后启动线程。

		for (int i=0; i<100;i++){
			AddTask task=new AddTask(list);
			threads[i]=new Thread(task);
			threads[i].start();
		}
		
		System.out.printf("Main: %d AddTask threads have been launched\n",threads.length);
		//13．使用join()方法等待线程完成。

		for (int i=0; i<threads.length; i++) {
		try {
			threads[i].join();
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
//		14．将列表的元素数量打印到控制台。

		System.out.printf("Main: Size of the List: %d\n",list.size());
//		15．创建100个PollTask对象及其对应的运行线程。将每个线程存放到上一步创建的数组中，然后启动线程。

		for (int i=0; i<threads.length; i++){
			PollTask task=new PollTask(list);
			threads[i]=new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d PollTask threads have been launched\n",threads.length);
		//使用join()方法等待线程完成。

		for (int i=0; i<threads.length; i++) {
		try {
		threads[i].join();
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
//		17．将列表的元素数量打印到控制台。

		System.out.printf("Main: Size of the List: %d\n",list.size());
	}
}
