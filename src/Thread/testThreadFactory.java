package Thread;

import org.omg.SendingContext.RunTime;

import java.util.HashMap;
import java.util.concurrent.*;

public class testThreadFactory {
    private static ConcurrentHashMap map = new ConcurrentHashMap();
    static class MyTask implements Runnable{

        @Override
        public void run() {
            map.put("ceshi",Thread.currentThread().getName());
            System.out.println("线程"+map);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(10,10,0L, TimeUnit.MILLISECONDS,
               new SynchronousQueue<>(), new ThreadFactory(){
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        return t;
                    }
                });

        for(int i=0;i<10;i++){
            es.submit(new MyTask());
        }
        System.out.println(map);
//        Runtime.getRuntime().availableProcessors();
//        Thread.sleep(2000);
    }
}
