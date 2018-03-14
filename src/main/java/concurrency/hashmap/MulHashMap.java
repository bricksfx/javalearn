package concurrency.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by bricks on 2018/2/2.
 */
public class MulHashMap {
    public static void main(String[] args) throws Exception{
        final Map<String, String> test = new HashMap<>();

        Thread tmp = new Thread(new Runnable() {
            @Override
            public void run(){
                int counter= 0;
                try {
                    Thread.sleep(1000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

                System.out.println(counter++ + " 次遍历map");
                for (Map.Entry<String, String> entry : test.entrySet()) {
                    if(counter > 12000){
                        System.out.println(counter);
                        break;
                    }
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                    counter++;
                }


            }
        },"test");


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            test.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();

                }
            }
        }, "ftf");
        t.start();
        t.join();

        tmp.start();
    }

}
