package interview.module.produce_consume.block_queue;

import interview.module.produce_consume.framework.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bricks on 2018/1/28.
 */
public class BlockingQueueModel implements Model{
    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModel(int cap){
        this.queue = new LinkedBlockingDeque<>(cap);
    }

    @Override
    public Runnable newRunnableConsumer(){
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer(){
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable{
        @Override
        public void consume() throws InterruptedException{
            Task task = queue.take();
//            Thread.sleep(20);
//            System.out.println("consume:" + task.no);
        }
    }
    private class ProducerImpl extends AbstractProducer implements Producer,Runnable{
        @Override
        public void produce() throws InterruptedException{
//            Thread.sleep((long) (1));
            Task task = new Task(increTaskNo.getAndIncrement());
            queue.put(task);
//            System.out.println("produce: " + task.no);
        }
    }

    public static void main(String[] args){
        Model model = new BlockingQueueModel(8);
        for(int i = 0; i < 3; i++){
            new Thread(model.newRunnableConsumer()).start();
        }
        for(int i = 0; i < 3; i++){
            new Thread(model.newRunnableProducer()).start();
        }
    }

}
