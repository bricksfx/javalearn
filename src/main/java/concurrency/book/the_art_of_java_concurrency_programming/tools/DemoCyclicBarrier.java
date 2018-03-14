package concurrency.book.the_art_of_java_concurrency_programming.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by bricks on 2018/3/8.
 */
public class DemoCyclicBarrier {
   static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

   public static void main(String[] args){
      new Thread(new Runnable() {
         @Override
         public void run() {
            try{
               cyclicBarrier.await();
            }catch (Exception ex){
               ex.printStackTrace();
            }
            System.out.println("thread1 - end wait");
         }
      }){

      }.start();

      try {
         cyclicBarrier.await();
      }catch (Exception ex){
         ex.printStackTrace();
      }
      System.out.println("thread2 - end wait");
   }
}
