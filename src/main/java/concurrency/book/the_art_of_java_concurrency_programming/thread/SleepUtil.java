package concurrency.book.the_art_of_java_concurrency_programming.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by bricks on 2018/2/20.
 */
public class SleepUtil {
    public static void sleepSeconds(Integer seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
