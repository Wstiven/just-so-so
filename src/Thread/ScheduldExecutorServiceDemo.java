package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//计划任务
public class ScheduldExecutorServiceDemo {
    public static void main(String args[]){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
//        ses.scheduleAtFixedRate(new Runnable() {//按照实际调动时间为维度
          ses.scheduleWithFixedDelay(new Runnable(){//按照任务完成为时间维度
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,3, TimeUnit.SECONDS);
    }
}
