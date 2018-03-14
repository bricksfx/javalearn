package interview.algorithm.sort.quicksort;

/**
 * Created by bricks on 2018/1/28.
 */
public class QuickSort {
    public static void quickSort(int n[], int left,int right){
        int dp;
        if(left < right){
            dp =  partition(n,left,right);
            quickSort(n,left,dp - 1);
            quickSort(n,dp+1,right);
        }
    }

    //这段错的
    public static int partition(int n[], int left,int right){
        int dp = left;
        for(int i = left; i <= right; i++){
            if(n[i] < n[dp]){
                int tmp = n[dp];
                n[dp] = n[i];
                n[i] = tmp;
                dp = i;
            }
        }
        printArr(n,left,right);
        return dp;
    }

    public static void printArr(int n[],int left,int right){
        for(int i = left; i <= right; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        /*
        int[] n = {3,2,1,6,5,7};
//        int dp = partition(n,0,5);
        quickSort(n,0,5);
        printArr(n,0,6);
        */

//        int[] b = {7,6,5,4,3,2,1};
        int[] b = {1,2,3,4,5,6,7};
        quickSort(b,0,6);
        printArr(b,0,6);
    }
}
