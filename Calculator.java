import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Welcome to the Java Calculator");
        startCalculator();
    }

    public static void startCalculator() {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculations = true;

        while (continueCalculations) {
            try {
                // Get calculate the values
                System.out.print("Enter an number : ");
                String expression = scanner.nextLine();

                double result = evaluateExpression(expression);
                System.out.println("Result: " + result);

                // Ask user to continue
                System.out.print("Do you want to perform another calculation? (yes/no): ");
                String choice = scanner.nextLine().toLowerCase();
                if (choice.equals("no")) {
                    continueCalculations = false;
                }

            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid expression.");
            }
        }

        scanner.close();
        System.out.println("Exiting the calculator. Goodbye!");
    }

    // Evaluates the expression manually
    public static double evaluateExpression(String expr) {
        double result = 0;
        double currentNumber = 0;
        char lastOperator = '+'; // Assume + at start

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0'); // Build number
            }

            // If operator OR last character
            if (!Character.isDigit(ch) || i == expr.length() - 1) {
                if (i == expr.length() - 1 && Character.isDigit(ch)) {
                    // If last digit, process number
                } else {
                    // Handle operator
                }

                switch (lastOperator) {
                    case '+':
                        result = add(result, currentNumber);
                        break;
                    case '-':
                        result = subtract(result, currentNumber);
                        break;
                    case '*':
                        result = multiply(result, currentNumber);
                        break;
                    case '/':
                        result = divide(result, currentNumber);
                        break;
                }

                lastOperator = ch;
                currentNumber = 0;
            }
        }
        return result;
    }

    // Basic Operations
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }
}
