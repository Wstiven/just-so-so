package Thread;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class testCurrentHashMap {

    public static void main(String args[]) throws InterruptedException {
        HashMap<String, AtomicInteger> map = new HashMap<>();
        AtomicInteger integer = new AtomicInteger(1);
        map.put("key", integer);

        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 999; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    synchronized (executorService){
                        map.get("key").incrementAndGet() ;
//                        map.put("key", key);
//                        System.out.println(key);
//                    }
                }
            });
        }
        Thread.sleep(3000); //模拟等待执行结束
        System.out.println("------" + map.get("key") + "------");
        executorService.shutdown();
    }
}
