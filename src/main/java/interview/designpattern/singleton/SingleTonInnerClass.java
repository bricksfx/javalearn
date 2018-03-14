package interview.designpattern.singleton;

import java.io.ObjectStreamException;

/**
 * Created by bricks on 2018/1/28.
 */

/*
静态内部类虽然保证了单例在多线程并发下的线程安全性，但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的。
*/
public class SingleTonInnerClass {
    private static class MySingletonHandler{
        private static SingleTonInnerClass instance = new SingleTonInnerClass();
    }
    private SingleTonInnerClass(){}
    public static SingleTonInnerClass getInstance(){
        return MySingletonHandler.instance;
    }

    //该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MySingletonHandler.instance;
    }
}
