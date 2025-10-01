import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Calculator & Converter ---");
            System.out.println("1. Calculator");
            System.out.println("2. Converter");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    calculator(sc);
                    break;
                case 2:
                    converter(sc);
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    
    public static void calculator(Scanner sc) {
    System.out.println("\nCalculator:");
    System.out.println("Available operators:");
    System.out.println("+, -, *, /, ^, %, sqrt, log, sin, cos, tan, !, exp, abs, inv");
    System.out.print("Enter first number: ");
    double a = sc.nextDouble();
    System.out.print("Enter an operator (+, -, *, /, ^, %, sqrt, log, sin, cos, tan, !, exp, abs, inv): ");
    String op = sc.next();

    double res = 0;
    boolean valid = true;

    if (op.equals("sqrt") || op.equals("log") || op.equals("sin") || op.equals("cos") || op.equals("tan") ||
        op.equals("!") || op.equals("exp") || op.equals("abs") || op.equals("inv")) {
        
        switch (op) {
            case "sqrt":
                if (a < 0) {
                    System.out.println("Cannot take square root of negative number.");
                    valid = false;
                } else {
                    res = Math.sqrt(a);
                }
                break;
            case "log":
                if (a <= 0) {
                    System.out.println("Logarithm undefined for zero or negative numbers.");
                    valid = false;
                } else {
                    res = Math.log10(a);
                }
                break;
            case "sin":
                res = Math.sin(Math.toRadians(a));
                break;
            case "cos":
                res = Math.cos(Math.toRadians(a));
                break;
            case "tan":
                res = Math.tan(Math.toRadians(a));
                break;
            case "!":
                if (a < 0 || a != (int) a) {
                    System.out.println("Factorial undefined for negative or non-integers.");
                    valid = false;
                } else {
                    res = factorial((int) a);
                }
                break;
            case "exp":
                res = Math.exp(a);
                break;
            case "abs":
                res = Math.abs(a);
                break;
            case "inv":
                if (a == 0) {
                    System.out.println("Cannot calculate inverse of zero.");
                    valid = false;
                } else {
                    res = 1 / a;
                }
                break;
        }
    } else {
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        switch (op) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                    valid = false;
                } else {
                    res = a / b;
                }
                break;
            case "^":
                res = Math.pow(a, b);
                break;
            case "%":
                if (b == 0) {
                    System.out.println("Cannot modulo by zero.");
                    valid = false;
                } else {
                    res = a % b;
                }
                break;
            default:
                System.out.println("Unknown operator.");
                valid = false;
        }
    }
    if (valid) {
        System.out.printf("Result: %.4f%n", res);
    }
}

    public static double factorial(int n) {
    double fact = 1;
    for (int i = 2; i <= n; i++) {
        fact *= i;
    }
    return fact;
}

    public static void converter(Scanner sc) {
        System.out.println("\nConverter:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.println("5. Kilograms to Pounds");
        System.out.println("6. Pounds to Kilograms");
        System.out.print("Choose conversion: ");
        int conv = sc.nextInt();
        System.out.print("Enter value: ");
        double val = sc.nextDouble();

        switch (conv) {
            case 1:
                System.out.printf("%.2f °C = %.2f °F%n", val, cToF(val));
                break;
            case 2:
                System.out.printf("%.2f °F = %.2f °C%n", val, fToC(val));
                break;
            case 3:
                System.out.printf("%.2f m = %.2f ft%n", val, mToFt(val));
                break;
            case 4:
                System.out.printf("%.2f ft = %.2f m%n", val, ftToM(val));
                break;
            case 5:
                System.out.printf("%.2f kg = %.2f lbs%n", val, kgToLb(val));
                break;
            case 6:
                System.out.printf("%.2f lbs = %.2f kg%n", val, lbToKg(val));
                break;
            default:
                System.out.println("Unknown conversion.");
        }
    }

    public static double cToF(double c) { return c * 9 / 5 + 32; }
    public static double fToC(double f) { return (f - 32) * 5 / 9; }
    public static double mToFt(double m) { return m * 3.28084; }
    public static double ftToM(double ft) { return ft / 3.28084; }
    public static double kgToLb(double kg) { return kg * 2.20462; }
    public static double lbToKg(double lb) { return lb / 2.20462; }
}
