package test.reflect.dynami_loading;

/**
 * Created by bricks on 17/7/16.
 */
public class DynamicLoad {
    public static void main(String[] args){
        try{
            String classType = "test.reflect.dynami_loading.Word";
            //动态加载类 在运行时刻加载
            Class c = Class.forName(classType);
            //通过类类型,创建类对象
            OfficeAble ob = (OfficeAble) c.newInstance();
            ob.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
