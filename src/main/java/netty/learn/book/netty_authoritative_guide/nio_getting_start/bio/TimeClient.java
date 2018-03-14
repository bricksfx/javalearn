package netty.learn.book.netty_authoritative_guide.nio_getting_start.bio;

import java.io.*;
import java.net.Socket;

/**
 * Created by bricks on 2018/2/9.
 */
public class TimeClient {
    public static void main(String[] args) throws Exception{
        int  port = 8080;
        if(args != null && args.length != 0){
            port = Integer.valueOf(args[0]) ;
        }
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()
            ));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER");
            System.out.println("send order 2 server succeed.");
            String resp = in.readLine();
            System.out.println("Now is:" + resp);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if(out != null){
                out.close();
                out = null;
            }
            if(in != null){
                in.close();
                in = null;
            }
            if(socket != null){
                socket.close();
                socket = null;
            }
        }
    }
}
