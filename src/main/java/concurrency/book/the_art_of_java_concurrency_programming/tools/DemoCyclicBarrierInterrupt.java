package concurrency.book.the_art_of_java_concurrency_programming.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by bricks on 2018/3/8.
 */
public class DemoCyclicBarrierInterrupt {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    Thread.sleep(200);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        thread.start();
        thread.interrupt();
        Thread.sleep(200);
        try{
            cyclicBarrier.await();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(cyclicBarrier.isBroken());
        }
    }

}
