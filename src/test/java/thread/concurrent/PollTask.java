package thread.concurrent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
* 类说明：
* @author pankx
* @date 2016年6月30日 下午4:01:16
*/
public class PollTask implements Runnable {
	//声明一个私有的ConcurrentLinkedDeque属性list，并指定它的泛型参数是String型的。
	private ConcurrentLinkedDeque list;
	
	public PollTask(ConcurrentLinkedDeque list) {
		this.list=list;
		}
	
	@Override
	public void run() {
		//实现run()方法。这个方法将列表中的10,000个字符串取出，总共取5,000次，每次取两个元素
		for (int i=0; i<=5000; i++) {
			list.pollFirst();
			list.pollLast();
			}
	}

}
