// ScientificCalculatorProject.java
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
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1 -> performAddition(scanner);
                case 2 -> performSubtraction(scanner);
                case 3 -> performMultiplication(scanner);
                case 4 -> performDivision(scanner);
                case 5 -> performPower(scanner);
                case 6 -> performSquareRoot(scanner);
                case 7 -> performSine(scanner);
                case 8 -> performCosine(scanner);
                case 9 -> performTangent(scanner);
                case 10 -> performNaturalLog(scanner);
                case 11 -> performLogBase10(scanner);
                case 12 -> performAbsolute(scanner);
                case 13 -> performRounding(scanner);
                case 14 -> performCeiling(scanner);
                case 15 -> performFloor(scanner);
                case 16 -> performMinMax(scanner);
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
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Power Function");
        System.out.println("6. Square Root");
        System.out.println("7. Sine (Degrees)");
        System.out.println("8. Cosine (Degrees)");
        System.out.println("9. Tangent (Degrees)");
        System.out.println("10. Natural Logarithm");
        System.out.println("11. Base 10 Logarithm");
        System.out.println("12. Absolute Value");
        System.out.println("13. Round");
        System.out.println("14. Ceiling");
        System.out.println("15. Floor");
        System.out.println("16. Min and Max");
        System.out.println("0. Exit");
        System.out.println("==================================");
    }

    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
        return a / b;
    }
    public static double power(double base, double exponent) { return Math.pow(base, exponent); }
    public static double squareRoot(double num) {
        if (num < 0) throw new IllegalArgumentException("Cannot take square root of negative number.");
        return Math.sqrt(num);
    }
    public static double sine(double degrees) { return Math.sin(Math.toRadians(degrees)); }
    public static double cosine(double degrees) { return Math.cos(Math.toRadians(degrees)); }
    public static double tangent(double degrees) { return Math.tan(Math.toRadians(degrees)); }
    public static double naturalLog(double num) {
        if (num <= 0) throw new IllegalArgumentException("Log undefined for zero or negative.");
        return Math.log(num);
    }
    public static double logBase10(double num) {
        if (num <= 0) throw new IllegalArgumentException("Log undefined for zero or negative.");
        return Math.log10(num);
    }
    public static double absolute(double num) { return Math.abs(num); }
    public static double round(double num) { return Math.round(num); }
    public static double ceiling(double num) { return Math.ceil(num); }
    public static double floor(double num) { return Math.floor(num); }
    public static double min(double a, double b) { return Math.min(a, b); }
    public static double max(double a, double b) { return Math.max(a, b); }

    // Input Handlers
    private static void performAddition(Scanner scanner) {
        performBinaryOp(scanner, "Addition", ScientificCalculatorProject::add);
    }
    private static void performSubtraction(Scanner scanner) {
        performBinaryOp(scanner, "Subtraction", ScientificCalculatorProject::subtract);
    }
    private static void performMultiplication(Scanner scanner) {
        performBinaryOp(scanner, "Multiplication", ScientificCalculatorProject::multiply);
    }
    private static void performDivision(Scanner scanner) {
        performBinaryOp(scanner, "Division", ScientificCalculatorProject::divide);
    }
    private static void performPower(Scanner scanner) {
        performBinaryOp(scanner, "Power", ScientificCalculatorProject::power);
    }
    private static void performSquareRoot(Scanner scanner) {
        performUnaryOp(scanner, "Square Root", ScientificCalculatorProject::squareRoot);
    }
    private static void performSine(Scanner scanner) {
        performUnaryOp(scanner, "Sine", ScientificCalculatorProject::sine);
    }
    private static void performCosine(Scanner scanner) {
        performUnaryOp(scanner, "Cosine", ScientificCalculatorProject::cosine);
    }
    private static void performTangent(Scanner scanner) {
        performUnaryOp(scanner, "Tangent", ScientificCalculatorProject::tangent);
    }
    private static void performNaturalLog(Scanner scanner) {
        performUnaryOp(scanner, "Natural Logarithm", ScientificCalculatorProject::naturalLog);
    }
    private static void performLogBase10(Scanner scanner) {
        performUnaryOp(scanner, "Base 10 Logarithm", ScientificCalculatorProject::logBase10);
    }
    private static void performAbsolute(Scanner scanner) {
        performUnaryOp(scanner, "Absolute Value", ScientificCalculatorProject::absolute);
    }
    private static void performRounding(Scanner scanner) {
        performUnaryOp(scanner, "Round", ScientificCalculatorProject::round);
    }
    private static void performCeiling(Scanner scanner) {
        performUnaryOp(scanner, "Ceiling", ScientificCalculatorProject::ceiling);
    }
    private static void performFloor(Scanner scanner) {
        performUnaryOp(scanner, "Floor", ScientificCalculatorProject::floor);
    }
    private static void performMinMax(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();
            System.out.println("Min: " + min(a, b));
            System.out.println("Max: " + max(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers.");
            scanner.next();
        }
    }

    private static void performBinaryOp(Scanner scanner, String opName, BinaryOperation operation) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();
            System.out.println("Result of " + opName + ": " + operation.apply(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers.");
            scanner.next();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performUnaryOp(Scanner scanner, String opName, UnaryOperation operation) {
        try {
            System.out.print("Enter number: ");
            double a = scanner.nextDouble();
            System.out.println("Result of " + opName + ": " + operation.apply(a));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    interface BinaryOperation {
        double apply(double a, double b);
    }

    interface UnaryOperation {
        double apply(double a);
    }
}
//done with the project 
