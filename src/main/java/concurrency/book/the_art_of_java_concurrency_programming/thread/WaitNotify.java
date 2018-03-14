package concurrency.book.the_art_of_java_concurrency_programming.thread;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bricks on 2018/2/27.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args){
        Wait wait = new Wait();
        Notify notify = new Notify();

        Thread waitThread = new Thread(wait,"wait-thread");
        Thread notifyThread = new Thread(notify,"notify-thread");
        waitThread.start();
        notifyThread.start();
    }

    static class Wait implements Runnable{
        @Override
        public void run(){
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() +
                                "flag is true. wait @" +
                                new SimpleDateFormat("HH:mm:ss").format(new Date())
                        );
                        lock.wait();
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() +
                        "flag is false. running @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date())
                );

            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                System.out.println(Thread.currentThread() +
                        "hold the lock @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date())
                );
                lock.notifyAll();
                flag = false;
                SleepUtil.sleepSeconds(2);
            }
            synchronized (lock){
                System.out.println(Thread.currentThread() +
                        "hold the lock again @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date())
                );
                SleepUtil.sleepSeconds(2);

            }
        }
    }
}
