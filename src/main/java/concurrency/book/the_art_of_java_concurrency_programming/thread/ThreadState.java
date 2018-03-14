package concurrency.book.the_art_of_java_concurrency_programming.thread;

import sun.tools.jconsole.Worker;

/**
 * Created by bricks on 2018/2/20.
 */
public class ThreadState {
    public static void main(String[] args){
        System.out.println("-----线程状态-----");
        TimeWaiting timeWaiting = new TimeWaiting();
        Waiting waiting = new Waiting();
        Blocked blocked = new Blocked();
        Blocked blocked1 = new Blocked();

        Thread timeWaitingTh = new Thread(timeWaiting,"time_waiting====bricks");
        Thread waitingTh = new Thread(waiting,"waiting===bricks");
        Thread blockedTh = new Thread(blocked,"blocked===1-bricks");
        Thread blocked1Th = new Thread(blocked1,"blocked===2-bricks");

        timeWaitingTh.start();
        waitingTh.start();
        blockedTh.start();
        blocked1Th.start();
    }

    static class TimeWaiting implements  Runnable{

        @Override
        public void run(){
            SleepUtil.sleepSeconds(100);
        }
    }

    static class Waiting implements Runnable{
        @Override
        public void run(){
            while(true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable{
        @Override
        public void run(){
            while(true){
                synchronized (Blocked.class){
                    SleepUtil.sleepSeconds(10);
                }
            }
        }
    }
}
