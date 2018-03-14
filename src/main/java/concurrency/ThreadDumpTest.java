package concurrency;

/**
 * Created by bricks on 2018/1/25.
 */

public class ThreadDumpTest {
    public void test(){
        for (int i = 0; i < 8 ; i++) {
            Thread th=new Thread(new TR(i));
            th.setName("MyThread-"+(1000+i));
            th.start();
        }
    }
    public static void main(String[] args) {
        ThreadDumpTest t=new ThreadDumpTest();
        t.test();
    }
    private class TR implements Runnable{
        int ins=0;
        TR(int i){
            ins=i;
        }
        public void run(){
            while (true) {
            }
        }
    }
}
