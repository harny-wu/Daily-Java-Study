package cn.daidai.javabase.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        MyRunnale myRunnale=new MyRunnale();
        for(int i=0;i<5;i++){
            exec.execute(myRunnale);
        }
        exec.shutdown(); //如果不关闭，程序则一直在运行
    }
}
