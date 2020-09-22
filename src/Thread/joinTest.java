package Thread;

public class joinTest {
    static class MyThread implements Runnable{

        boolean flag=true;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId()+"执行了！");
            try {
                //Thread.sleep(6000);
                if(flag){
                    Thread.currentThread().join();
                    flag=false;
                }
                System.out.println(Thread.currentThread().getId()+"结束了!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread());
        thread1.start();
        Thread thread2 = new Thread(new MyThread());
        thread2.start();
    }
}
