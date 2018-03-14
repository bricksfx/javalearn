package concurrency.util;

import java.util.Random;

/**
 * Created by bricks on 2018/3/7.
 */
public class RandomUtil {


    public static long[] randomArr(int length){
        long[] arr = new long[length];
        for(int i = 0; i < length; i++){
            arr[i] = randomLong(0,length);
        }
        return arr;
    }

    public static long randomLong(long min,long max){
        long rangeLong = min + (((long) (new Random().nextDouble() * (max - min))));
        return rangeLong;
    }

    public static void main(String[] args){
        long[] arr = randomArr(1000);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }
}
