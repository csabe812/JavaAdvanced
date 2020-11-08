
class MyTasker implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Running index at: " + i);
		}
	}
	
}

public class MultiThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyTasker());
		Thread t2 = new Thread(new MyTasker());
		t1.start();
		t2.start();
	}

}
