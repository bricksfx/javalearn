package interview.designpattern.singleton;

/**
 * Created by bricks on 2018/1/28.
 */
public class SingletonHungerLockMethod {
    private static volatile SingletonHungerLockMethod instance;
    private SingletonHungerLockMethod(){};

    public static synchronized SingletonHungerLockMethod getInstance(){
        if(instance == null){
            instance = new SingletonHungerLockMethod();
        }
        return instance;
    }

}
