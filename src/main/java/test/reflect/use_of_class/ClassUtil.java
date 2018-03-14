package test.reflect.use_of_class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by bricks on 17/7/16.
 */
public class ClassUtil {
    public static void printClassMessage(Object obj) throws Exception{
        Class c1 = obj.getClass();
        System.out.println("类名称:" + c1.getName());
        Method[] methods =  c1.getMethods();
        for(Method item : methods){
            String methodName = item.getName();
            Class returnType = item.getReturnType();
            Class[] paramsList = item.getParameterTypes();
            System.out.print(returnType + " " + methodName + "(");
            for(Class paramTmp : paramsList){
                System.out.print(paramTmp.getName() + ",");
            }
            System.out.print(")" + "\n");
        }
        System.out.println("-------------------获取成员变量信息");

        Field[] fs = c1.getDeclaredFields();
        for(Field field:fs){
            Class fieldType = field.getType();
            String typeName = fieldType.getTypeName();
            String fieldName = field.getName();
            System.out.println(typeName + " " +fieldName);

        }
        System.out.println("-------------------获取构造函数信息");


        Constructor[] cs = c1.getDeclaredConstructors();
        for(Constructor constructor:cs){
            String csName = constructor.getName();
            Class[] paramsList = constructor.getParameterTypes();
            System.out.print(csName + "(");
            for(Class params:paramsList){
                System.out.print(params.getName());
            }
            System.out.println(")\n");
        }


    }
}
