package interview.designpattern.singleton;

/**
 * Created by bricks on 2018/1/28.
 */
public class SingleTonDCL {
    private static volatile SingleTonDCL instance;
    private SingleTonDCL(){};
    public static SingleTonDCL getInstance(){
        if(instance == null){
            synchronized(SingleTonDCL.class){
               if(instance == null){
                   instance = new SingleTonDCL();
               }
            }
        }
        return instance;
    }
}
