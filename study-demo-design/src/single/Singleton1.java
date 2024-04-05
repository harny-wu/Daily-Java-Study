package single;

/**
 * 懒汉式——双重检查（线程安全）【推荐使用】
 * 模拟下出问题的流程（假设不加volatile关键字）：
 *
 * 当 线程1 判断 INSTANCE 为空，进入同步逻辑，继续检查为空，则创建对象
 * 如果此时发生指令重排序，执行 1->3->2 步骤，先创建了空对象，然后赋值给引用，此时还没来得及调用构造方法
 * 其他线程此时判断 INSTANCE 不为 null，则直接返回 INSTANCE，但是此时对象并没有初始化完毕，就被其他线程使用，可能导致空指针异常
 *
 * synchronized不能禁止重排序吗？
 * synchronized采用加锁机制保证程序的有序性，被加锁的代码块多个线程只能串性执行，但是其内部是可以发生指令重排序的，因为指令重排序对单线程是不影响的。
 *
 * 作者：码bug的小砖家
 * 链接：https://juejin.cn/post/6984065491560038413
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author daiYang_wu
 */

public class Singleton1 {
    private volatile static Singleton1 INSTANCE;
    private Singleton1(){}

    public static Singleton1 getInstance() {
        if (INSTANCE == null){
            synchronized (Singleton1.class){
                INSTANCE = new Singleton1();
            }
        }
        return INSTANCE;
    }
}
