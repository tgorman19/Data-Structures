import java.util.Scanner;
public class BadSubscriptCaught {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String[] nameList = {"Joe", "Ted", "James", "Harry", "Kevin", "Jack", "Nate", "Ryan", "Jason", "Matt"};
        try{
            System.out.println("Enter a array value 1-10:");
            int UserInput = sc.nextInt();
            System.out.println(nameList[UserInput-1]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Invalid Array Element");
        }
    }
}