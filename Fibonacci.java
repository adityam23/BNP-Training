import java.util.Scanner;
public class Fibonacci{
     public static void main(String []args){
        final int upto = 89;
        int t1 = 1, t2 = 1;
        int sum = 0;
        while(sum <= 89){
            System.out.print(t1 + " + ");
            sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
     }
}