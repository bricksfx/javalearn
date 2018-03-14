package test.reflect.use_of_class;

/**
 * Created by bricks on 17/7/16.
 */
public class ClassDemo {
    public static void main(String[] args) throws Exception{

        Foo foo = new Foo();


        //c1,c2,c3表示了foo的类类型(class type)
        Class c1 = Foo.class;
        Class c2 = foo.getClass();
        Class c3 = null;
        try
        {
            c3 = Class.forName("test.reflect.use_of_class.Foo");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println(c1==c2);
        System.out.println(c1==c3);
        //可以通过类的类类型创建类的对象实例,通过c1,c2,c3 创建foo的实例
        try {
            Foo foo1 = (Foo) c1.newInstance();
            foo1.test();
        }catch (InstantiationException ex){
            ex.printStackTrace();

        }catch (IllegalAccessException ex){
            ex.printStackTrace();
        }
        String s = "test";
        ClassUtil.printClassMessage(s);

    }

}

class Foo{
    void test(){
        System.out.println("test");
    }

}
