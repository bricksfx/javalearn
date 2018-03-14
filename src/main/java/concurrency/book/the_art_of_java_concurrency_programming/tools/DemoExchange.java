package concurrency.book.the_art_of_java_concurrency_programming.tools;

import java.util.concurrent.Exchanger;

/**
 * Created by bricks on 2018/3/8.
 */
public class DemoExchange {
    private static final Exchanger<String> exchange = new Exchanger<>();

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String aData = "银行流水A";
                    String bData = exchange.exchange(aData);
                    System.out.println("thread-A获取到的B的数据:" + bData);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }) .start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String bData = "银行流水B";
                    String aData = exchange.exchange(bData);
                    System.out.println("thread-B获取到的A的数据:" + aData);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
