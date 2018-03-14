package concurrency.book.the_art_of_java_concurrency_programming.thread;

/**
 * Created by bricks on 2018/2/26.
 */
public class Interrupted {
    public static void main(String[] args){
        Thread sleepRunner = new Thread(new SleepRunner(),"sleep-runner");
        Thread busyRunner = new Thread(new BusyRunner(),"busy-runner");
//        sleepRunner.setDaemon(true);
//        busyRunner.setDaemon(true);
        sleepRunner.start();
//        busyRunner.start();

        SleepUtil.sleepSeconds(4);


        sleepRunner.interrupt();
//        busyRunner.interrupt();
        System.out.println("sleep-runner :" + sleepRunner.isInterrupted());
//        System.out.println("busy-runner :" + busyRunner.isInterrupted());
        SleepUtil.sleepSeconds(1);
    }

    static class SleepRunner implements Runnable{
        private Integer counter = 0;
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()) {
//            while(true){
                System.out.println(Thread.currentThread().isInterrupted());
                SleepUtil.sleepSeconds(1);
                System.out.println("第" + counter++ + "次sleep");
            }
        }
    }

    static class BusyRunner implements Runnable{
        private Boolean afterInterrupted = false;

        public void setAfterInterrupted(Boolean afterInterrupted){
            this.afterInterrupted = afterInterrupted;
        }

        @Override
        public void run(){
            while (!Thread.currentThread().isInterrupted()){
                if(afterInterrupted){
                    System.out.println("test");
                }
            }
        }
    }
}
