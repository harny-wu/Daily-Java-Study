package cn.daidai.alg.cache;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lixk
 * @Date: 2018/5/9 16:40
 * @Description: 缓存工具类测试
 */
public class Test {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        String key = "id";
        //不设置过期时间
        System.out.println("***********不设置过期时间**********");
        Cache.put(key, 123);
        System.out.println("key:" + key + ", value:" + Cache.get(key));
        System.out.println("key:" + key + ", value:" + Cache.remove(key));
        System.out.println("key:" + key + ", value:" + Cache.get(key));

        //设置过期时间
        System.out.println("\n***********设置过期时间**********");
        Cache.put(key, "123456", 1000);
        System.out.println("key:" + key + ", value:" + Cache.get(key));
        Thread.sleep(2000);
        System.out.println("key:" + key + ", value:" + Cache.get(key));

        System.out.println("\n***********100读写性能测试************");
        //创建有10个线程的线程池，将1000000次操作分10次添加到线程池
        int threads = 10;
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        //每批操作数量
        int batchSize = 100;

        //添加
        {
            CountDownLatch latch = new CountDownLatch(threads);
            AtomicInteger n = new AtomicInteger(0);
            long start = System.currentTimeMillis();

            for (int t = 0; t < threads; t++) {
                pool.submit(() -> {
                    for (int i = 0; i < batchSize; i++) {
                        int value = n.incrementAndGet();
                        Cache.put(key + value, value, 300000);
                    }
                    latch.countDown();
                });
            }
            //等待全部线程执行完成，打印执行时间
            latch.await();
            System.out.printf("添加耗时：%dms\n", System.currentTimeMillis() - start);
        }

        //查询
        {
            CountDownLatch latch = new CountDownLatch(threads);
            AtomicInteger n = new AtomicInteger(0);
            long start = System.currentTimeMillis();
            for (int t = 0; t < threads; t++) {
                pool.submit(() -> {
                    for (int i = 0; i < batchSize; i++) {
                        int value = n.incrementAndGet();
                        Cache.get(key + value);
                    }
                    latch.countDown();
                });
            }
            //等待全部线程执行完成，打印执行时间
            latch.await();
            System.out.printf("查询耗时：%dms\n", System.currentTimeMillis() - start);
        }

        System.out.println("当前缓存容量：" + Cache.size());
    }
}

