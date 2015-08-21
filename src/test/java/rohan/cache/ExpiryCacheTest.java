package rohan.cache;

import java.util.concurrent.TimeUnit;

public class ExpiryCacheTest {

    static ExpiryCache<Integer, Integer> cache = new ExpiryCacheImpl<Integer, Integer>();

    static Integer key;

    static Integer value;

    static int ttl;

    public static void main(String[] args) throws InterruptedException {
        ExpiryCacheTest expiryCacheTest = new ExpiryCacheTest();
        ExpiryCacheThread expiryCacheThread1 = expiryCacheTest.new ExpiryCacheThread();
        key = 1;
        value = 10;
        ttl = 1;
        expiryCacheThread1.run();
        Thread.sleep(2000);
        System.out.println("Should fail: " + cache.get(1));
        key = 2;
        value = 20;
        ttl = 10;
        expiryCacheThread1.run();
        System.out.println("Should Pass: " + cache.get(2));
        System.out.println("Should fail: " + cache.get(3));
    }

    class ExpiryCacheThread implements Runnable {

        @Override
        public void run() {
            cache.put(key, value, ttl, TimeUnit.SECONDS);
            System.out.println("Should Pass: " + cache.get(key));
        }
    }

}
