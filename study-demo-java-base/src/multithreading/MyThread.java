package multithreading;

public class MyThread extends Thread{
    private  int ticket=10;

    public MyThread(String name){super(name);}
    public void run() {
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println(currentThread().getName()+" 卖票：ticket "+this.ticket--);
            }
        }

    }
}
