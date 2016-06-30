package thread;
/**
* 类说明：
* @author pankx
* @date 2016年6月28日 下午12:34:08
*/
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        @SuppressWarnings("rawtypes")
        //InheritableThreadLocal类是ThreadLocal类的子类。
        //ThreadLocal中每个线程拥有它自己的值，与ThreadLocal
        //不同的是，InheritableThreadLocal允许一个线程以及该
        //线程创建的所有子线程都可以访问它保存的值。
		private InheritableThreadLocal threadLocal = new InheritableThreadLocal();
        @SuppressWarnings("unchecked")
		@Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
            		new Thread(new Runnable() {
					
					@Override
					public void run() {
					//子线程
						System.out.println("子线程的数据："+threadLocal.get());
					}
				}).start();
            Thread.sleep(2000);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
         MyRunnable sharedRunnableInstance = new MyRunnable();
         Thread thread1 = new Thread(sharedRunnableInstance);
         Thread thread2 = new Thread(sharedRunnableInstance);
         thread1.start();
         thread2.start();
    }

}