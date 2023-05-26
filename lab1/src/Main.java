import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("Welcome to factorial and power of two calculator: ");

            Scanner readerInt = new Scanner(System.in);

            System.out.println("Enter a number: ");
            int n = readerInt.nextInt();
            System.out.println("Result of factorial");
            System.out.println(factorial(n));

            System.out.println("Result of power of two");
            System.out.println(powerOfTwo(n));

            System.out.println("Menu");
            System.out.println("0 - Exit");
            System.out.println("1 - Continue");
            int menu = readerInt.nextInt();

            if (menu == 0) {
                System.out.println("Goodbye");
                running = false;
            }
        }
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static long powerOfTwo(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * 2;
        }
        return result;
    }
}
