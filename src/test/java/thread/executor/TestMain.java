package thread.executor;

/**
 * 类说明：
 * 
 * @author pankx
 * @date 2016年6月28日 下午2:13:21
 */
public class TestMain {
	public static void main(String[] args) {
		ThreadServer server = new ThreadServer();
		for (int i = 0; i < 100; i++) {
			Task task = new Task("Task " + i);
			server.executeTask(task);
		}
		server.endServer();
	}
}
