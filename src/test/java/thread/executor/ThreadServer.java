package thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
* 类说明：创建一个线程池服务， 用来执行使用执行者接受的所有任务。创建一个Server类
* @author pankx
* @date 2016年6月28日 下午1:57:15
*/
public class ThreadServer {

	//.声明一个类型为ThreadPoolExecutor，名为executor的属性。
	private  ThreadPoolExecutor executor=null;
	public  ThreadServer(){
		executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
	}
	//实现executeTask()方法，接收Task对象作为参数并将其提交到执行者。首先，写入一条信息到控制台，表明有一个新的任务到达。
	public void executeTask(Task task){
		System.out.printf("Server: A new task has arrived\n");
		executor.execute(task);
		System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
	}
	//实现endServer()方法，在这个方法中，调用执行者的shutdown()方法来结束任务执行。
	 public void endServer() {
		executor.shutdown();
		}

}
