
public class SingletonThreadSafe {
	private static SingletonThreadSafe instance;

	public SingletonThreadSafe() {
	}

	public static synchronized SingletonThreadSafe getInstance() {
		if (instance == null) {
			instance = new SingletonThreadSafe();
		}
		return instance;
	}
}
