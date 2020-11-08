import java.util.Scanner;

class MyVolatileTasker implements Runnable {

	private volatile boolean isRunning = true;
	
	@Override
	public void run() {
		while(isRunning) {
			System.out.println("I am running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void kill() {
		isRunning = false;
	}
	
}

public class VolatileThread {

	public static void main(String[] args) {
		
		MyVolatileTasker mt = new MyVolatileTasker();
		Thread t1 = new Thread(mt);
		t1.start();
		
		System.out.println("Press ENTER to exit...");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		mt.kill();

	}

}
