import java.util.concurrent.TimeUnit;

public class D {

	private static boolean stopRequested = false;

	private static void requestStop() {
		stopRequested = true;
	}

	private static boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				System.out.println(2);
				while (!stopRequested) {
					i++;
					// System.out.println("* i: " + i); // test
					// 아래 stopRequested = true;를 인식하지 못함.
				}
				System.out.println(4 + "/" + i);
			}
		});

		backThread.start();
		System.out.println(1);
		TimeUnit.SECONDS.sleep(1);
		System.out.println(3);
		stopRequested = true;

	}
}
