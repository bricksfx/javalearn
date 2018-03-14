package netty.learn.book.netty_authoritative_guide.nio_getting_start.bio;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bricks on 2018/2/9.
 */
public class TimeCientThreadPool {
    public static void main(String[] args) throws Exception {
        AtomicInteger counter = new AtomicInteger(0);
        int port = 8080;
        if (args != null && args.length != 0) {
            port = Integer.valueOf(args[0]);
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        while (true) {
            counter.getAndIncrement();
            Socket socket = null;
            socket = new Socket("127.0.0.1", port);
            if(executor.getQueue().size() > 3){
                Thread.sleep(10);
            }
            ClientThread clientThread = new ClientThread(socket,counter);
            executor.execute(clientThread);
        }

    }

}
