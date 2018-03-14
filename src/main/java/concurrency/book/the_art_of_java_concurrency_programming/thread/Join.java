package concurrency.book.the_art_of_java_concurrency_programming.thread;

/**
 * Created by bricks on 2018/2/27.
 */
public class Join {
    public static void main(String[] args){
        Thread previous = Thread.currentThread();
        for(int i = 0; i < 10; i++){
            JoinDemo joinDemo = new JoinDemo(previous);
            Thread tmp = new Thread(
                    joinDemo,"thread-" + i
            );
            tmp.start();
            previous = tmp;
        }
    }
    static class JoinDemo implements Runnable{
        private Thread thread;
        public JoinDemo(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run(){
            try{
                thread.join();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terimated.");
        }
    }
}
