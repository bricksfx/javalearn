package interview.module.produce_consume.framework;

/**
 * Created by bricks on 2018/1/28.
 */
public abstract class AbstractProducer implements Producer,Runnable{

    @Override
    public void run(){
        while (true){
            try{
                produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
