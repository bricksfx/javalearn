package concurrency.book.the_art_of_java_concurrency_programming.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bricks on 2018/3/1.
 */
public class ThreadId {
    private static AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return nextId.getAndIncrement();
        }
    };
    public static int get(){
        return threadId.get();
    }

    public static void main(String[] args){
        System.out.println(get());
        new Thread(){
            @Override
            public void run(){
                System.out.println(get()) ;
                System.out.println(get()) ;
                System.out.println(get()) ;
            }
        }.start();
    }


}
