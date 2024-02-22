import java.util.Scanner;

public class ArrayLab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How long do you want your array to be?");
        System.out.println("Max number of values is 20");
        int len = sc.nextInt();
        while (len > 20) {
            System.out.println("Too many values");
            System.out.println("Enter a new length:");
            len = sc.nextInt();
        }

        double[] num = new double[len];

        System.out.println("Enter the values of your array:");
        for (int i = 0; i < len; i++){
            num[i] = sc.nextDouble();
        }

        System.out.println("Array:");
        for (int i = 0; i < len; i++){
            System.out.println(num[i]);
        }
    }
}