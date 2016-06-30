package thread;
/**
* 类说明：
* @author pankx
* @date 2016年6月27日 下午6:44:01
*/
public class Test implements Runnable{

	public synchronized void get(){
		System.out.println(Thread.currentThread().getId());
		set();
	}

	public synchronized void set(){
		System.out.println(Thread.currentThread().getId());
	}

	@Override
	public void run() {
		get();
	}
	public static void main(String[] args) {
		Test ss=new Test();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
	}
}
