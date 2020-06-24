import java.util.Scanner;
public class Pattern{
     public static void main(String []args){
        final int upto = 4;
        for(int i = 1; i <= upto ; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
     }
}