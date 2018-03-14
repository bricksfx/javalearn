package concurrency.book.the_art_of_java_concurrency_programming.container_and_frame.fork_join;

import concurrency.util.RandomUtil;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by bricks on 2018/3/7.
 */
public class QuickSort extends RecursiveAction{
    private long[] arr;
    private int low;
    private int high;

    public QuickSort(long[] arr){
        this.arr = arr;
        this.low = 0;
        this.high = arr.length - 1;
    }
    public QuickSort(long[] arr,int low,int high){
        this.arr = arr;
        this.low = low;
        this.high = high;
    }
    private int partition(){
        long key = arr[low];
        int left =  low;
        int right = high;
        while(left < right){
            while(arr[right] >= key && left < right){
                right--;
            }
            arr[left] = arr[right];
            while(arr[left] < key && left < right){
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left]  = key;
        return left;

    }

    private void printArr(long[] array){
        for(int i = low; i <= high; i++){
            System.out.print(
//                    i  +":" +
                            array[i] + ",");
        }
        System.out.println("\n");
    }

    @Override
    public void compute(){
        int pivot;
        if(low < high){
            pivot = partition();
            QuickSort left = new QuickSort(arr,low,pivot-1);
            QuickSort right = new QuickSort(arr,pivot + 1 , high);
            left.fork();
            right.fork();
        }
    }

    public static void main(String[] args) throws Exception{
//        long[] arr = {4,5,8,9,0,13,8,1,11,10,6,12,11,14,1};
//        long[] arr = {9,11,1,1,5,9,9,1,2,2,7,13,9,11,4};
        long[] arr = RandomUtil.randomArr(10);

        System.out.println("start======");
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("\nstart======");

        ForkJoinTask sort = new QuickSort(arr);

        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(sort);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        if(sort.getException() != null) {
            sort.getException().printStackTrace();
        }
        pool.shutdown();

        System.out.println("end======");
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
}
