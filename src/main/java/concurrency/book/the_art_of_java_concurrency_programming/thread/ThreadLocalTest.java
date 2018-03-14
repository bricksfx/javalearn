package concurrency.book.the_art_of_java_concurrency_programming.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by bricks on 2018/3/1.
 */
public class ThreadLocalTest {
    ThreadLocal<Long> tmp = new ThreadLocal<>();

    ConcurrentLinkedQueue tmp2 = new ConcurrentLinkedQueue();


}
