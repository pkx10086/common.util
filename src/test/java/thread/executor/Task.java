package thread.executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
* 类说明：
* @author pankx
* @date 2016年6月28日 下午2:08:12
*/
public class Task implements Runnable{
	//声明一个类型为Date，名为initDate的属性，来存储任务创建日期，和一个类型为String，名为name的属性，来存储任务的名称。

	private Date initDate;
	private String name;
	
	//.实现Task构造器，初始化这两个属性。
	public Task(String name){
		initDate=new Date();
		this.name=name;
	}

	@Override
	public void run() {
		//首先，将initDate属性和实际日期（这是任务的开始日期）写入到控制台。

		System.out.printf("%s: Task %s: Created on: %s\n",Thread.currentThread().getName(),name,initDate);
		System.out.printf("%s: Task %s: Started on: %s\n",Thread.currentThread().getName(),name,new Date());
		//.然后，使任务睡眠一个随机时间。

		try {
			Long duration=(long)(Math.random()*10);
			System.out.printf("%s: Task %s: Doing a task during %dseconds\n",Thread.currentThread().getName(),name,duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		//最后，将任务完成时间写入控制台。

		System.out.printf("%s: Task %s: Finished on: %s\n",Thread.currentThread().getName(),name,new Date());
	}

}
