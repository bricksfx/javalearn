package concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bricks on 2018/1/25.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                8,16,200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5)
        );
        for(int i = 0; i < 7; i++){
            MyTask myTask = new MyTask(i);
            threadPoolExecutor.execute(myTask);
        }
        threadPoolExecutor.shutdown();
    }
}
class MyTask implements Runnable{
    private int taskNum;
    MyTask(int i){
       taskNum = i;
    }

    @Override
    public void run(){
//        sum();
        while (true){

        }
    }

    private long sum(){
        long sum = 0;
        Random rand=new Random();
        int i=(int)(Math.random()*100);
        int j=rand.nextInt(100000);
        for(int counter = 0; counter < j; counter++){
            sum += counter;
        }
        return sum;
    }
}
