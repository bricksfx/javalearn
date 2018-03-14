package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bricks on 2018/2/1.
 */
public class CASTest {
    static AtomicInteger test = new AtomicInteger(0);
    public static void main(String[] args){
        test.getAndAdd(1);
    }

}
