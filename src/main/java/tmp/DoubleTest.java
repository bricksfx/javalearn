package tmp;

/**
 * Created by bricks on 2018/1/17.
 */
public class DoubleTest {
    public static void main(String[] args){
        Double bid = new Double("2.3");
        bid = bid * 100;
        System.out.println(bid);
        String bidFormated = String.format("%.0f",bid);
        bid = new Double(bidFormated);
        System.out.println(bid);

        System.out.println(3*0.1 == 0.3);
        System.out.println(2*0.1 == 0.2);
        System.out.println(25*0.1 == 2.5);
        String tmp = "30000.0";
        System.out.println("------");
        String[] ee = tmp.split("\\.");
        for(int i = 0; i < ee.length;i++){
            System.out.println(ee[i]);
        }
        System.out.println("------");
        System.out.println(tmp);

        Double eee = new Double("9.0E-4");
        System.out.println(eee);
        System.out.println(eee*100);
    }
}