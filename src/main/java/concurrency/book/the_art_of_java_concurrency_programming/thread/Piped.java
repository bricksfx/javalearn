package concurrency.book.the_art_of_java_concurrency_programming.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by bricks on 2018/2/27.
 */
public class Piped {
    public static void main(String[] args) throws Exception{
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        try {
            writer.connect(reader);
            Thread tmp = new Thread(
                    new Print(reader) ,"print"
            );
            tmp.start();
            int receive = 0;
            while((receive = System.in.read()) != -1){
                writer.write(receive);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            writer.close();
        }

    }
    static class Print implements Runnable{

        private PipedReader reader;

        public Print(PipedReader reader){
            this.reader = reader;
        }
        @Override
        public void run(){
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1){
                    System.out.print((char) receive);
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
