package concurrent.alternateprinting;

public class AlternatePrintingByNotify {
    private static final Object lock = new Object();
    private static final int MAX_COUNT = 100;
    private static int curr = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while (curr <= MAX_COUNT) {
                    if (curr % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " :" + curr);
                        curr++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {

                while (curr <= MAX_COUNT) {
                    if (curr % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " :" + curr);
                        curr++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
    }
}
