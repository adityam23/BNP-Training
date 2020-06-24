import java.util.Scanner;
public class Factorial{
     public static void main(String []args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number to find its factorial : ");
        int ip = s.nextInt();
        int fact = 1;
        while(ip>1){
            fact *= ip;
            ip--;
        }
        System.out.println("Factorial is : " + fact);
     }
}

