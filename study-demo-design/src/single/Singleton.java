package single;


/**
 * 静态内部类不会随着外部类的加载而加载，只有静态内部类的静态成员被调用时才会进行加载。该实现方式比较简单，而且可以达到懒加载的效果，
 * 同时由JVM保证了多线程并发访问的正确性（利用了classloder的机制来保证初始化instance时只有一个线程）。
 */
public class Singleton {
    private Singleton(){}
    private static class Inner{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return Inner.INSTANCE;
    }
}