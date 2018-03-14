package netty.learn.book.netty_authoritative_guide.nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by bricks on 2018/2/10.
 */
public class BaseChannelDemo {
    public static void main(String[] args) throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("/Users/bricks/java/learn/com.bricksfx.learn/src/main/java/netty/learn/book/netty_authoritative_guide/nio/channel/test.txt"
                ,"rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        int byteRead = inChannel.read(buf);
        while(byteRead != -1){
            System.out.println("Read " + byteRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            byteRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
