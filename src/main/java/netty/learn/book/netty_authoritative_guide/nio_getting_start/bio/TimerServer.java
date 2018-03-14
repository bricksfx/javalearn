package netty.learn.book.netty_authoritative_guide.nio_getting_start.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by bricks on 2018/2/8.
 */
public class TimerServer {
    public static void main(String[] args) throws IOException{
        int port =  8080;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 40, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        if(args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("Timer server started");
            Socket socket = null;
            while(true){
                socket = server.accept();
                TimerServerHandler timerServerHandler = new TimerServerHandler(socket);
                executor.execute(timerServerHandler);
                if(executor.getQueue().size() > 3){
                    Thread.sleep(3);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            System.out.println("Timer server closed");
            server.close();
            server = null;
        }
    }
}
