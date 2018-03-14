package interview.designpattern.singleton;

/**
 * Created by bricks on 2018/1/28.
 */
public class SingletonLazyUnsafeWithoutCheck {
    private static volatile SingletonLazyUnsafeWithoutCheck instance = null;

    private SingletonLazyUnsafeWithoutCheck(){};

    public static SingletonLazyUnsafeWithoutCheck getInstance(){
        if(instance == null){
            instance = new SingletonLazyUnsafeWithoutCheck();
        }
        return instance;
    }

}
