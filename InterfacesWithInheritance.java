
interface Vehicle {
	void doSound();
}

interface Ship extends Vehicle {
	void sink();
}

abstract class Plane implements Vehicle {
	protected boolean hasPropeller;

	abstract void fly();

	public Plane() {

	}

	public Plane(boolean hasPropeller) {
		this.hasPropeller = hasPropeller;
	}

	public boolean isHasPropeller() {
		return hasPropeller;
	}

	public void setHasPropeller(boolean hasPropeller) {
		this.hasPropeller = hasPropeller;
	}

}

class FloatPlane extends Plane implements Ship {

	public FloatPlane() {
		super(false);
		System.out.println("A floatplane has been created!");
	}

	@Override
	public void doSound() {
		System.out.println("Some kinda FloatPlane sound....");
	}

	@Override
	public void sink() {
		System.out.println("OMG. It has been sunk...");
	}

	@Override
	void fly() {
		System.out.println("Yeah. It is flying...");
	}

}

public class InterfacesWithInheritance {

	public static void main(String[] args) {
		Vehicle vehicle = new FloatPlane();
		FloatPlane floatPlane = (FloatPlane) vehicle;
		floatPlane.setHasPropeller(true);
		floatPlane.sink();
		floatPlane.fly();
		floatPlane.doSound();
	}

}
