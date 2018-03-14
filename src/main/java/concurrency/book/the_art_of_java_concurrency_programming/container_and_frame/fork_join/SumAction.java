package concurrency.book.the_art_of_java_concurrency_programming.container_and_frame.fork_join;

import io.netty.util.ReferenceCountUtil;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by bricks on 2018/3/7.
 */
public class SumAction extends RecursiveTask<Integer>{

    private static int threadHold = 3;
    private int low;
    private int high;

    SumAction(int low,int high){
        this.low = low;
        this.high = high;
    }
    private int sum(int start,int end){
        System.out.println("-----" + Thread.currentThread().getName());
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += i;
        }
        return sum;
    }

    @Override
    public Integer compute(){
        if((high - low) < threadHold){
            return sum(low,high);
        }
        int middle = (low + high)/2;
        SumAction left = new SumAction(low,middle);
        SumAction right = new SumAction(middle+1,high);
        left.fork();
        right.fork();
        return left.join() + right.join();
    }

    public static void main(String[] args) throws Exception{
        ForkJoinPool pool = new ForkJoinPool() ;

        RecursiveTask<Integer> res = new SumAction(1,1000);
        pool.submit(res);
        System.out.println(res.get());

    }
}
