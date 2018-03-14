package concurrency.book.the_art_of_java_concurrency_programming.tools;

import java.util.concurrent.CountDownLatch;

/**
 * Created by bricks on 2018/3/8.
 */
public class CountdownLatchDemo {
    private static final int THREAD_NUM = 30;
    private static final CountDownLatch countdownLatch = new CountDownLatch(THREAD_NUM);

    public static void main(String[] args) throws Exception{
        for(int i = 0; i < THREAD_NUM; i++){
            Thread tmp = new Thread(new DataCrawl(),"爬取线程-" + i);
            tmp.start();
        }
        countdownLatch.await();
        dataReport();
    }

    static class DataCrawl implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " 开始爬取数据");
            countdownLatch.countDown();
        }
    }

    private static void dataReport(){
        System.out.println("\n=====开始生成报表====");
    }

}
