import java.util.concurrent.TimeUnit;

public class E {

	private static boolean stopRequested;

	private static synchronized void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				System.out.println(2);
				while (!stopRequested()) {
					i++;
					// System.out.println("* i: " + i); // test
					// requestStop()와 stopRequested()에 synchronized 사용.
				}
				System.out.println(4 + "/" + i);
			}
		});

		backThread.start();
		System.out.println(1);
		TimeUnit.SECONDS.sleep(1);
		System.out.println(3);
		requestStop();
	}
}
