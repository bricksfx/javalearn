package concurrency.book.the_art_of_java_concurrency_programming.thread;

/**
 * Created by bricks on 2018/2/26.
 */
public class Shutdown {
    public static void main(String[] args){

    }
    static class Runner implements Runnable{
        private volatile Integer counter = 0;
        @Override
        public void run(){
            while(true){
                counter++;
            }

        }
    }
}
