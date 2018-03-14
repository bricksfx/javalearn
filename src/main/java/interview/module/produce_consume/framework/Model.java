package interview.module.produce_consume.framework;

/**
 * Created by bricks on 2018/1/28.
 */
public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
