//Import the scanner
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Print the beginning text and use scanner for user's money amount
        System.out.println("Enter Amount:");
        Scanner sc = new Scanner(System.in);
        String money = sc.nextLine();

        // Format the user's input to remove the dollar sign and convert the string to a double
        String temp = money.replace('$', ' ');
        double formatMoney = Double.parseDouble(temp);


        // Change the user's input all into pennies
        int totalCents = (int)(formatMoney * 100);

        // Create new variable for later when the original money needs to be used again
        int originalCents = totalCents;

        // Find how many quarters are in the user's input and leave only the remaining cents
        int quarters = totalCents / 25;
        totalCents %= 25;

        // Find how many dimes are in the user's remaining input and leave only the remaining cents
        int dimes = totalCents / 10;
        totalCents %= 10;

        // Find how many nickels are in the user's remaining input and leave only the remaining cents
        int nickels = totalCents / 5;
        totalCents %= 5;

        // The remaining cents are pennies
        int pennies = totalCents;


        // Print the converted money and only print the value for a coin if there is at least 1 present
        System.out.println("You have:");
        if (quarters != 0) {
            System.out.println(quarters + " quarters");
        }
        if (dimes != 0) {
            System.out.println(dimes + " dimes");
        }
        if (nickels != 0) {
            System.out.println(nickels + " nickels");
        }
        if (pennies != 0) {
            System.out.println(pennies + " pennies");
        }


        // Ask the user what else they would like to buy and show the price of each item
        System.out.println("What Would You Like To Buy With Your Money? (Enter A Digit)");
        System.out.println("1: T-Shirt, $20.00");
        System.out.println("2: Book, $10.00");
        System.out.println("3: Chocolate Bar, $2.00");


        // Set the user's input to a variable and put the item's price into pennies
        int item = sc.nextInt();
        int shirt = 2000;
        int book = 1000;
        int chocolate = 200;


        // The program enters this if statement when the user selects t-shirt
        if (item == 1) {
            // If the user's original input is less than the price of a shirt, the program prints the user does not have enough money
            if (originalCents < shirt) {
                System.out.println("You do not have enough money.");
            }
            // Otherwise, the program removes the price of the shirt and goes through the money conversion from up top
            else {
                int newCents = originalCents - shirt;
                int new_quarters = newCents / 25;
                newCents %= 25;
                int new_dimes = newCents / 10;
                newCents %= 10;
                int new_nickels = newCents / 5;
                newCents %= 5;
                int new_pennies = newCents;

                // Print that the user bought a t-shirt and print the remaining converted money
                System.out.println("You bought a t-shirt.");
                System.out.println("You now have:");
                if (new_quarters != 0) {
                    System.out.println(new_quarters + " quarters");
                }
                if (new_dimes != 0) {
                    System.out.println(new_dimes + " dimes");
                }
                if (new_nickels != 0) {
                    System.out.println(new_nickels + " nickels");
                }
                if (new_pennies != 0) {
                    System.out.println(new_pennies + " pennies");
                }
            }
        }
        // The program enters this if statement when the user selects book
        if (item == 2) {
            // If the user's original input is less than the price of a book, the program prints the user does not have enough money
            if (originalCents < book) {
                System.out.println("You do not have enough money.");
            }
            // Otherwise, the program removes the price of the book and goes through the money conversion from up top
            else {
                int newCents = originalCents - book;
                int new_quarters = newCents / 25;
                newCents %= 25;
                int new_dimes = newCents / 10;
                newCents %= 10;
                int new_nickels = newCents / 5;
                newCents %= 5;
                int new_pennies = newCents;

                // Print that the user bought a book and print the remaining converted money
                System.out.println("You bought a book.");
                System.out.println("You now have:");
                if (new_quarters != 0) {
                    System.out.println(new_quarters + " quarters");
                }
                if (new_dimes != 0) {
                    System.out.println(new_dimes + " dimes");
                }
                if (new_nickels != 0) {
                    System.out.println(new_nickels + " nickels");
                }
                if (new_pennies != 0) {
                    System.out.println(new_pennies + " pennies");
                }
            }
        }
        // The program enters this if statement when the user selects chocolate
        if (item == 3) {
            // If the user's original input is less than the price of chocolate, the program prints the user does not have enough money
            if (originalCents < chocolate) {
                System.out.println("You do not have enough money.");
            }
            // Otherwise, the program removes the price of the chocolate and goes through the money conversion from up top
            else {
                int newCents = originalCents - chocolate;
                int new_quarters = newCents / 25;
                newCents %= 25;
                int new_dimes = newCents / 10;
                newCents %= 10;
                int new_nickels = newCents / 5;
                newCents %= 5;
                int new_pennies = newCents;

                // Print that the user bought chocolate and print the remaining converted money
                System.out.println("You bought a chocolate bar.");
                System.out.println("You now have:");
                if (new_quarters != 0) {
                    System.out.println(new_quarters + " quarters");
                }
                if (new_dimes != 0) {
                    System.out.println(new_dimes + " dimes");
                }
                if (new_nickels != 0) {
                    System.out.println(new_nickels + " nickels");
                }
                if (new_pennies != 0) {
                    System.out.println(new_pennies + " pennies");
                }
            }
        }

    }
}