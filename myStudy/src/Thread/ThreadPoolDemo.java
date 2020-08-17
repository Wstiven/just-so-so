package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static class myTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":Thread Id:"+ Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  static void main(String args[]){
        myTask myTask = new myTask();
//        ExecutorService es = Executors.newFixedThreadPool(5);
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            es.submit(myTask);
        }
    }
}
