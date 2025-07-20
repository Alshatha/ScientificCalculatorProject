// ScientificCalculator.java
import java.util.Scanner;
import java.util.InputMismatchException;

public class ScientificCalculatorProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear bad input
                continue;
            }

            switch (choice) {
                case 1 -> performAddition(scanner);
                case 2 -> performSubtraction(scanner);
                case 0 -> {
                    System.out.println("Exiting calculator. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n====== Scientific Calculator ======");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("0. Exit");
        System.out.println("==================================");
    }

    // Arithmetic
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Perform Methods (User Input Handling)
    private static void performAddition(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = add(num1, num2);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid number input!");
            scanner.next(); // Clear bad input
        }
    }

    private static void performSubtraction(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = subtract(num1, num2);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid number input!");
            scanner.next(); // Clear bad input
        }
    }
}

