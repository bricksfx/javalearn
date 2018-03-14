package interview.designpattern.singleton;

/**
 * Created by bricks on 2018/1/28.
 */
public class SingleTonUnsafeLockBlock {
    private static SingleTonUnsafeLockBlock instance;
    private SingleTonUnsafeLockBlock(){};
    public static SingleTonUnsafeLockBlock getInstance(){
        if(instance == null){
            synchronized (SingleTonUnsafeLockBlock.class){
                instance = new  SingleTonUnsafeLockBlock();
            }
        }
        return instance;
    }
}
