package classLoad;

/**
 * @author daiYang_wu
 */
public class Test1 {
    public static void main(String[] args) {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
    }
}
