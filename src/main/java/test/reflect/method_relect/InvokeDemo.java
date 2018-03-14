package test.reflect.method_relect;

import java.lang.reflect.Method;

/**
 * Created by bricks on 17/7/16.
 */
public class InvokeDemo {
    //method 反射
    public static void main(String[] args) throws Exception{
        Class c = A.class;
        A tmp = (A)c.newInstance();
        Method test = c.getMethod("add", int.class,int.class);
        Object o = test.invoke(tmp,10,20);

    }

}

class A{
    public void add(int a, int b){
        System.out.println(a+b);
    }

}
