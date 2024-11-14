package concurrent.TakeTurnsPrint;

/**
 * @author daiYang_wu
 */
public class TakeTurnsPrintByLock {
    private static boolean flag = true;
    private static int num = 1;
    public synchronized void print1(){
        for (int i = 0; i < 50; i++){
            while (flag){
                System.out.println(Thread.currentThread() + ": " + num++);
                flag = false;
            }
        }
    }
    public synchronized void print2(){
        for (int i = 0; i < 50; i++){
            while (!flag){
                System.out.println(Thread.currentThread() + ": " + num++);
                flag = true;
            }
        }
    }
    public static void main(String[] args) {
        TakeTurnsPrintByLock takeTurnsPrintByLock = new TakeTurnsPrintByLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
             takeTurnsPrintByLock.print1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                takeTurnsPrintByLock.print2();
            }
        }).start();
    }
}
