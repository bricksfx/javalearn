package interview.designpattern.singleton;

/**
 * Created by bricks on 2018/1/28.
 */
public class SingletonClassFactoryEnum {
    private enum MyEnumSingleton{
        singletonFactory;
        private Singleton instance;
        /*
            枚举类的构造方法在类加载时被实例化
         */
        private MyEnumSingleton(){
            instance = new Singleton();
        }
        public Singleton getInstance(){
            return instance;
        }
    }
    public static Singleton getInstance(){
        return MyEnumSingleton.singletonFactory.getInstance();
    }
}
class Singleton{
    public Singleton(){};
}