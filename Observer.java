import java.util.ArrayList;
import java.util.List;

class Subject {
	private List<Observer> observers = new ArrayList<>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}
}

public abstract class Observer {
	Subject subject;

	abstract void update();

	public static void main(String[] args) {
		Subject subject = new Subject();
		new BinaryObserver(subject);
		new OctalObserver(subject);
		System.out.println("First state change: 1024");
		subject.setState(1024);
		System.out.println("Second state change: 4096");
		subject.setState(4096);
	}
}

class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	void update() {
		System.out.println("Binary string: " + Integer.toBinaryString(this.subject.getState()));
	}

}

class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	void update() {
		System.out.println("Octal string: " + Integer.toOctalString(this.subject.getState()));
	}

}
