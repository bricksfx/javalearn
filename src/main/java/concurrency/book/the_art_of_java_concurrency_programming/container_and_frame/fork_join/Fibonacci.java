package concurrency.book.the_art_of_java_concurrency_programming.container_and_frame.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by bricks on 2018/3/7.
 */
public class Fibonacci extends RecursiveTask<Integer>{

    final int n;

    Fibonacci(int n){
        this.n = n;
    }

    private int compute(int small){
        final int[] result =  { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        return result[small];
    }
    @Override
    public Integer compute(){
        if(n <= 10){
            return compute(n);
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        Fibonacci f2 = new Fibonacci(n - 2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }

    public static void main(String[] args) throws Exception{
        ForkJoinTask<Integer> fjt = new Fibonacci(44);
        ForkJoinPool fjp = new ForkJoinPool();
        Future<Integer> result = fjp.submit(fjt);

        System.out.println(result.get());
    }
}
