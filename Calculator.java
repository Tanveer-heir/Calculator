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
        System.out.println("7. Kilometers to Miles");
        System.out.println("8. Miles to Kilometers");
        System.out.println("9. Liters to Gallons");
        System.out.println("10. Gallons to Liters");
        System.out.println("11. Kilometers/hour to Miles/hour");
        System.out.println("12. Miles/hour to Kilometers/hour");
        System.out.println("13. Celsius to Kelvin");
        System.out.println("14. Kelvin to Celsius");
        System.out.println("15. Square meters to Square feet");
        System.out.println("16. Square feet to Square meters");
        System.out.println("17. Hours to Minutes");
        System.out.println("18. Minutes to Seconds");
        System.out.println("19. Joules to Calories");
        System.out.println("20. Calories to Joules");
        System.out.println("21. Pascals to Atmospheres");
        System.out.println("22. Atmospheres to Pascals");
        System.out.println("23. Grams to Ounces");
        System.out.println("24. Ounces to Grams");

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
            case 7:
                System.out.printf("%.2f km = %.2f miles%n", val, kmToMiles(val));
                break;
            case 8:
                System.out.printf("%.2f miles = %.2f km%n", val, milesToKm(val));
                break;
            case 9:
                System.out.printf("%.2f liters = %.2f gallons%n", val, litersToGallons(val));
                break;
            case 10:
                System.out.printf("%.2f gallons = %.2f liters%n", val, gallonsToLiters(val));
                break;
            case 11:
                System.out.printf("%.2f km/h = %.2f mph%n", val, kmhToMph(val));
                break;
            case 12:
                System.out.printf("%.2f mph = %.2f km/h%n", val, mphToKmh(val));
                break;
            case 13:
                System.out.printf("%.2f °C = %.2f K%n", val, cToK(val));
                break;
            case 14:
                System.out.printf("%.2f K = %.2f °C%n", val, kToC(val));
                break;
            case 15:
                System.out.printf("%.2f m² = %.2f ft²%n", val, sqmToSqft(val));
                break;
            case 16:
                System.out.printf("%.2f ft² = %.2f m²%n", val, sqftToSqm(val));
                break;
            case 17:
                System.out.printf("%.2f hours = %.2f minutes%n", val, hoursToMinutes(val));
                break;
            case 18:
                System.out.printf("%.2f minutes = %.2f seconds%n", val, minutesToSeconds(val));
                break;
            case 19:
                System.out.printf("%.2f joules = %.2f calories%n", val, joulesToCalories(val));
                break;
            case 20:
                System.out.printf("%.2f calories = %.2f joules%n", val, caloriesToJoules(val));
                break;
            case 21:
                System.out.printf("%.2f pascals = %.6f atmospheres%n", val, pascalsToAtm(val));
                break;
            case 22:
                System.out.printf("%.6f atmospheres = %.2f pascals%n", val, atmToPascals(val));
                break;
            case 23:
                System.out.printf("%.2f grams = %.2f ounces%n", val, gramsToOunces(val));
                break;
            case 24:
                System.out.printf("%.2f ounces = %.2f grams%n", val, ouncesToGrams(val));
                break;
            default:
                System.out.println("Unknown conversion.");
        }
    }

    public static double cToF(double c) {
        return c * 9 / 5 + 32;
    }

    public static double fToC(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double mToFt(double m) {
        return m * 3.28084;
    }

    public static double ftToM(double ft) {
        return ft / 3.28084;
    }

    public static double kgToLb(double kg) {
        return kg * 2.20462;
    }

    public static double lbToKg(double lb) {
        return lb / 2.20462;
    }

    public static double kmToMiles(double km) {
        return km * 0.621371;
    }

    public static double milesToKm(double miles) {
        return miles / 0.621371;
    }

    public static double litersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static double gallonsToLiters(double gallons) {
        return gallons / 0.264172;
    }

    public static double kmhToMph(double kmh) {
        return kmh * 0.621371;
    }

    public static double mphToKmh(double mph) {
        return mph / 0.621371;
    }

    public static double cToK(double celsius) {
        return celsius + 273.15;
    }

    public static double kToC(double kelvin) {
        return kelvin - 273.15;
    }

    public static double sqmToSqft(double sqm) {
        return sqm * 10.7639;
    }

    public static double sqftToSqm(double sqft) {
        return sqft / 10.7639;
    }

    public static double hoursToMinutes(double hrs) {
        return hrs * 60;
    }

    public static double minutesToSeconds(double mins) {
        return mins * 60;
    }

    public static double joulesToCalories(double joules) {
        return joules / 4.184;
    }

    public static double caloriesToJoules(double calories) {
        return calories * 4.184;
    }

    public static double pascalsToAtm(double pascals) {
        return pascals / 101325;
    }

    public static double atmToPascals(double atm) {
        return atm * 101325;
    }

    public static double gramsToOunces(double grams) {
        return grams * 0.035274;
    }

    public static double ouncesToGrams(double ounces) {
        return ounces / 0.035274;
    }

}
