package test.reflect.dynami_loading;

/**
 * Created by bricks on 17/7/16.
 */
public class StaticLoad {
    //静态加载
    //new 对象是静态加载,在编译时刻就需要加载所有可能用到的类
    public static void main(String[] args){
        String type = "word";
        if(type.equals("word")){
            Word word = new Word();
        }
        if(type.equals("excel")){
            Excel excel = new Excel();
        }
    }
}
