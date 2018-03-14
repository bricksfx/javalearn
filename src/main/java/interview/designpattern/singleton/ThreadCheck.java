package interview.designpattern.singleton;

/**
 * Created by bricks on 2018/1/28.
 */
public class ThreadCheck extends Thread{
    @Override
    public void run(){
        System.out.println(SingleTonDCL.getInstance().hashCode());
    }

    public static void main(String[] args){
        ThreadCheck[] chk = new ThreadCheck[10];
        for(int i = 0; i < chk.length; i++){
            chk[i] = new ThreadCheck();
        }
        for(int i = 0; i < chk.length; i++){
            chk[i].start();
        }

    }
}
