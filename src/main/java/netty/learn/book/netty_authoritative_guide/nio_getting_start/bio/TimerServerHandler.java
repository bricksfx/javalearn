package netty.learn.book.netty_authoritative_guide.nio_getting_start.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by bricks on 2018/2/8.
 */
public class TimerServerHandler implements Runnable{
    private Socket socket;
    public TimerServerHandler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(
                    this.socket.getInputStream()
            ));
            out = new PrintWriter(
                this.socket.getOutputStream(),true
            );
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if(body == null){
                    break;
                }
                System.out.println("The time server receive order :"+ body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?
                        new Date(System.currentTimeMillis()).toString(): "BAD ORDER";
                out.println(currentTime);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(in != null){
                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(this.socket != null){
                try{
                    this.socket.close();
                }catch (Exception soe){
                    soe.printStackTrace();
                }
                this.socket = null;
            }
        }

    }


}