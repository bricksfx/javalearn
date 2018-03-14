package netty.learn.book.netty_authoritative_guide.nio_getting_start.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bricks on 2018/2/9.
 */
public class ClientThread implements Runnable{
    private Socket socket;
    private AtomicInteger counter;
    public ClientThread(Socket socket,AtomicInteger counter){
        this.socket = socket;
        this.counter = counter;
    }

    @Override
    public void run(){
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()
            ));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("QUERY TIME ORDER");
            System.out.println("send order "+ counter + "time server succeed.\n");
            String resp = in.readLine();
            System.out.println("Now is:" + resp);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(out != null){
                out.close();
                out = null;
            }
            if(in != null){
                try {
                    in.close();
                }catch (Exception inex){
                    inex.printStackTrace();
                }
                in = null;
            }
            if(socket != null){
                try {
                    socket.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
