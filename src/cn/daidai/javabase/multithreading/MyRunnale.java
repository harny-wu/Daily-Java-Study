package cn.daidai.javabase.multithreading;

public class MyRunnale implements Runnable {
    //共享资源
   /*synchronized基本原则和实例
   第一条:当一个线程访问某对象的synchronized方法或者synchronized代码块时，其他线程对该对象的该synchronized方法或者synchronized代码块的访问将被阻塞。
   第二条:当一个线程访问某对象的synchronized方法或者synchronized代码块时，其他线程仍然可以访问该对象的非同步代码块。
   第三条:当一个线程访问某对象的synchronized方法或者synchronized代码块时，其他线程对该对象的其他的synchronized方法或者synchronized代码块的访问将被阻塞。
    使用方式：
    1.修饰实例方法: 作用于当前对象实例加锁，进入同步代码前要获得 当前对象实例的锁
    2.修饰静态方法: 也就是给当前类加锁，会作用于类的所有对象实例 ，进入同步代码前要获得 当前 class 的锁
    3.修饰代码块 ：指定加锁对象，对给定对象/类加锁。synchronized(this|object) 表示进入同步代码库前要获得给定对象的锁。synchronized(类.class) 表示进入同步代码前要获得 当前 class 的锁
    */

    private int ticket = 1000;

    @Override
    public void run() {
//        synchronizedMethod1();
        while (true){
            buy();
        }
    }

    //synchronized 修饰buy
    public synchronized void buy() {
        if (ticket > 0) {
            ticket = ticket - 1;
            System.out.println(Thread.currentThread().getName() + " 卖票：ticket " + this.ticket);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void synchronizedMethod1() {
        while (true) {
            //synchronized锁住实例对象购票的操作
            synchronized (this) {
                if (ticket > 0) {
                    ticket = ticket - 1;
                    System.out.println(Thread.currentThread().getName() + " 卖票：ticket " + this.ticket);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}