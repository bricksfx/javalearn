package interview.designpattern.singleton;

/**
 * Created by bricks on 2018/1/28.
 */
public class SingletonHunger {
    private static volatile SingletonHunger instance = new SingletonHunger();

    //另一种实现方式
    /*
    private static SingletonHunger instance = null;
    static {
        instance = new SingletonHunger();
    }
    */


    private SingletonHunger(){};
    public static SingletonHunger getInstance(){
        return instance;
    }
}
