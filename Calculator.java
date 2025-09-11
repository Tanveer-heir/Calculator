import java.util.Scanner;

public class CalculatorConverter {

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

    // Calculator mode
    public static void calculator(Scanner sc) {
        System.out.println("\nCalculator:");
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter an operator (+, -, *, /, ^): ");
        char op = sc.next().charAt(0);
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        double res = 0;
        boolean valid = true;
        switch (op) {
            case '+': res = a + b; break;
            case '-': res = a - b; break;
            case '*': res = a * b; break;
            case '/': 
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                    valid = false;
                } else { res = a / b; }
                break;
            case '^': res = Math.pow(a, b); break;
            default:
                System.out.println("Unknown operator.");
                valid = false;
        }
        if (valid) {
            System.out.printf("Result: %.4f%n", res);
        }
    }

    // Converter mode
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

    // Converter utility methods
    public static double cToF(double c) { return c * 9 / 5 + 32; }
    public static double fToC(double f) { return (f - 32) * 5 / 9; }
    public static double mToFt(double m) { return m * 3.28084; }
    public static double ftToM(double ft) { return ft / 3.28084; }
    public static double kgToLb(double kg) { return kg * 2.20462; }
    public static double lbToKg(double lb) { return lb / 2.20462; }
}
