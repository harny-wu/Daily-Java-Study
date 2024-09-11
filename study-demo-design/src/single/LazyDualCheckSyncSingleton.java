package single;

/**
 * 双重检验，线程安全 double-checked lockin，DLC
 */
public class LazyDualCheckSyncSingleton {
    private LazyDualCheckSyncSingleton(){}

    //为了解决多线程环境下重排序带来的问题。
    //
    //创建对象会经过三个步骤（不是原子性）：
    //
    //创建空的对象（分配内存）
    //调用构造方法（对象初始化）
    //将构造好的实例地址赋值给引用
    //
    //
    //模拟下出问题的流程（假设不加volatile关键字）：
    //
    //当 线程1 判断 INSTANCE 为空，进入同步逻辑，继续检查为空，则创建对象
    //如果此时发生指令重排序，执行 1->3->2 步骤，先创建了空对象，然后赋值给引用，此时还没来得及调用构造方法
    //其他线程此时判断 INSTANCE 不为 null，则直接返回 INSTANCE，但是此时对象并没有初始化完毕，就被其他线程使用，可能导致空指针异常
    //
    //作者：码bug的小砖家
    //链接：https://juejin.cn/post/6984065491560038413
    //来源：稀土掘金
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private static volatile LazyDualCheckSyncSingleton instance;

    public static LazyDualCheckSyncSingleton getInstance() {
        if (instance == null){
            synchronized (LazyDualCheckSyncSingleton.class) {
                // 双重校验 + volatile 保障可见性
                if (instance == null) {
                    instance = new LazyDualCheckSyncSingleton();
                }
            }
        }
        return instance;
    }

}
