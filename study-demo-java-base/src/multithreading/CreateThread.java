package multithreading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
1、继承Thread类创建线程类
2、通过Runnable接口创建线程类
3、通过Callable和Future创建线程

1、采用实现Runnable、Callable接口的方式创建多线程时，
优势是：
线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。
在这种方式下，多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
劣势是：
编程稍微复杂，如果要访问当前线程，则必须使用Thread.currentThread()方法。
2、使用继承Thread类的方式创建多线程时，
优势是：
编写简单，如果需要访问当前线程，则无需使用Thread.currentThread()方法，直接使用this即可获得当前线程。
劣势是：
线程类已经继承了Thread类，所以不能再继承其他父类。
3、Runnable和Callable的区别
(1) Callable规定（重写）的方法是call()，Runnable规定（重写）的方法是run()。
(2) Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。
(3) call方法可以抛出异常，run方法不可以。
(4) 运行Callable任务可以拿到一个Future对象，表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。通过Future对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果
 */
public class CreateThread {

    public static void main(String[] args) {

        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

        //1.继承thread,无法共享一份资源
//        new MyThread("继承thread1").start();
//        new MyThread("继承thread2").start();
//        new MyThread("继承thread3").start();

        //2.通过Runnable接口创建线程类
        //(1)原始版本
//        MyRunnale runnale = new MyRunnale();
//        new Thread(runnale, "runnable1").start();//可以通过runnable共享一份资源
//        new Thread(runnale, "runnable2").start();
//        new Thread(runnale, "runnable3").start();
        //(2)lamda简化
        new Thread(() -> {
            System.out.println("lamda简化");
        }).start();

        //3.通过Callable和Future创建线程
        /**
         * (1)创建Callable接口的实现类，并重写call()方法,该call()方法作为线程的执行体，且有返回值
         * (2)创建了Callable接口的实现类的实例，并用FutureTask()方法包装对象，该FutureTask()对象实现了
         *    将对象的返回值包装的功能
         * (3)使用FutureTask对象将Thread对象的target，创建并启动线程
         * (4)调用FutureTask对象的get()方法获得子线程执行结束后的返回值
         * */
        class TaskWithResult implements Callable<String> {
            private int id;

            public TaskWithResult(int id) {
                this.id = id;
            }

            @Override
            public String call() throws Exception {
                return "result of TaskWithResult" + id;
            }
        }
        TaskWithResult taskWithResult = new TaskWithResult(1);
        FutureTask futureTask=new FutureTask(taskWithResult);
        new Thread(futureTask).start();
        try {
            System.out.println("线程执行后返回值:"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
