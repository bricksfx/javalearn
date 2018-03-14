package tmp;

import java.util.Scanner;

/**
 * Created by bricks on 2018/1/22.
 */
public class ScnnerDemo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            String tmp = scanner.next();
            System.out.println(tmp);
        }
        scanner.close();
    }
}
