package test.reflect.generic;


import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by bricks on 17/7/16.
 */
public class GenericTest {
    public static void main(String[] args) throws Exception{
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("test");
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2);
        //反射的操作是在编译之后的操作
        //c1 == c2 结果为true,说明编译之后集合的泛型是去泛型化的
        //java中集合的泛型是防止错误输入的,只在编译阶段有效,绕过编译就有效
        Method listm = c2.getMethod("add",Object.class);
        listm.invoke(list1,200);
        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
        System.out.println(list1);

    }
}
