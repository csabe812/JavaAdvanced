import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskUnit implements Runnable {

	private int id;

	public TaskUnit(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task has been started, id: " + id);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task finished, id: " + id);
	}

}

public class ExecutorServicePool {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			executorService.submit(new TaskUnit(i));
		}
		executorService.shutdown();

		System.out.println("All of the jobs have been assigned...");

		executorService.awaitTermination(60, TimeUnit.SECONDS);

		System.out.println("All of the jobs have been finished.");

	}
}
