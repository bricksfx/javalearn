package concurrency.book.the_art_of_java_concurrency_programming.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by bricks on 2018/3/8.
 */
public class DemoSemaphore {
    private static final Integer THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(5);

    private static volatile Boolean notStart = true;

    public static void main(String[] args) throws Exception{
        for(int i = 0; i < THREAD_COUNT; i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        while(notStart){
                            Thread.yield();
                        }
                        semaphore.acquire();
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " : save data");
                        semaphore.release();
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
            );
        }
        Thread.sleep(1000);
        notStart = false;
        threadPool.shutdown();
    }
}
