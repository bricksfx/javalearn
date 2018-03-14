package concurrency.book.the_art_of_java_concurrency_programming.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bricks on 2018/2/20.
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws Exception{
        List<Job> jobs = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            Integer properity = i < 10? Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job = new Job(properity);
            jobs.add(job);
            Thread thread = new Thread(job,"thread-" + i);
            thread.setPriority(properity);
            thread.start();
        }

        notStart = false;
        Thread.sleep(50000);

        notEnd = false;


    }




    static class Job implements  Runnable{

        private Integer counter = 0;
        private Integer proterity;

        public Job(Integer proterity){
            this.proterity = proterity;
        }


        @Override
        public void run(){
            while (notStart){
                Thread.yield();//确保main线程将十个线程启动成功
            }
            while (notEnd){
                Thread.yield();//让出CPU资源,使得十个线程自由竞争
                counter ++;//记录竞争状态,反应线程优先级
            }
            System.out.println(Thread.currentThread().getName() + " priority" +
                    proterity + ":" + counter);
        }

    }

}


