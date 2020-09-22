package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraceThreadPoolExecutor {
    class TraceThreadPoolDemo extends ThreadPoolExecutor{

        public TraceThreadPoolDemo(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(wrap(task,new Exception("client statck trace"),Thread.currentThread().getName()));
        }

        private Runnable wrap(final Runnable task,final Exception clientStack,String clientThreadName){
            return  new Runnable() {
                @Override
                public void run() {
                    try {
                        task.run();
                    }catch (Exception e){
                        clientStack.getStackTrace();
                        throw  e;
                    }
                }
            };
        }
    }
}
