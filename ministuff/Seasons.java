import java.util.Scanner;
public class Season{
     public static void main(String []args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number to get corresponding season : ");
        int ip = s.nextInt();
        switch(ip){
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("No such season exists!");
        }
     }
}
