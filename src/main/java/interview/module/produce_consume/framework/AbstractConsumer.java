package interview.module.produce_consume.framework;


/**
 * Created by bricks on 2018/1/28.
 */
public abstract class AbstractConsumer implements Consumer,Runnable{

    @Override
    public void run(){
        while (true){
            try{
                consume();
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
