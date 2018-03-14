package interview.module.produce_consume.block_queue;

import interview.module.produce_consume.framework.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bricks on 2018/1/29.
 */
public class WaitNotifyModel implements Model{
    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> buffer = new LinkedList<>();
    private int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public WaitNotifyModel(int cap){
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer(){
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer(){
        return new ProducerImpl();

    }

    private class ConsumerImpl extends AbstractConsumer implements Consumer,Runnable {
        @Override
        public void consume() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == 0) {
                    System.out.println("consumer is waiting");
                    BUFFER_LOCK.wait();
                }

                Task task = buffer.poll();
                assert task != null;
//                Thread.sleep(5);
                System.out.println("consume" + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    private class ProducerImpl extends AbstractProducer implements Producer,Runnable {
        @Override
        public void produce() throws InterruptedException{
//            Thread.sleep(2);
            synchronized (BUFFER_LOCK){
                while (buffer.size() == cap){
                    BUFFER_LOCK.wait();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("produce: " + task.no);
                BUFFER_LOCK.notifyAll();
                System.out.println("produce notifyAll");
            }
        }
    }
    public static void main(String[] args){
        Model model = new WaitNotifyModel(8);
        for(int i = 0; i < 4; i++){
            new Thread(model.newRunnableConsumer()).start();
        }
        for(int i = 0; i < 4; i++){
            new Thread(model.newRunnableProducer()).start();
        }
    }

}
