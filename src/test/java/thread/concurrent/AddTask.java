package thread.concurrent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
* 类说明：
* @author pankx
* @date 2016年6月30日 下午3:58:25
*/
//创建一个名为AddTask的类，实现Runnable接口。
public class AddTask implements Runnable {

	//声明一个私有的ConcurrentLinkedDeque属性list，并指定它的泛型参数是String型的。
	private ConcurrentLinkedDeque list;
	
	public AddTask(ConcurrentLinkedDeque list) {
		this.list=list;
	}	
	
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		for (int i=0; i<10000; i++){
			list.add(name+": Element "+i);
			//System.out.println("peek data:"+list.peek());
			//System.out.println("poll data:"+list.poll());
			list.offer(name+":Element"+i);
		}
	}
}
