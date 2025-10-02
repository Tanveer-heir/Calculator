import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorConverterGUI extends JFrame {
    private final JComboBox<String> modeCombo;
    private final JComboBox<String> operationCombo;
    private final JTextField input1Field;
    private JTextField input2Field;
    private JButton calculateButton;
    private JLabel resultLabel;

    public CalculatorConverterGUI() {
        setTitle("Calculator & Converter");
        setSize(450, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Mode:"), gbc);
        modeCombo = new JComboBox<>(new String[] { "Calculator", "Converter" });
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(modeCombo, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Operation:"), gbc);
        operationCombo = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(operationCombo, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Input 1:"), gbc);
        input1Field = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(input1Field, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Input 2 (if needed):"), gbc);
        input2Field = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(input2Field, gbc);

      
        calculateButton = new JButton("Calculate");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

       
        resultLabel = new JLabel("Result: ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);

        
        updateOperations();

        
        modeCombo.addActionListener(e -> updateOperations());

        calculateButton.addActionListener(e -> performCalculation());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateOperations() {
        operationCombo.removeAllItems();
        if (modeCombo.getSelectedItem().equals("Calculator")) {
            String[] calcOps = {
                    "+", "-", "*", "/", "^", "%",
                    "sqrt", "log", "sin", "cos", "tan",
                    "!", "exp", "abs", "inv"
            };
            for (String op : calcOps)
                operationCombo.addItem(op);
            input2Field.setEnabled(true);
        } else {
            String[] convOps = {
                    "Celsius to Fahrenheit", "Fahrenheit to Celsius",
                    "Meters to Feet", "Feet to Meters",
                    "Kilograms to Pounds", "Pounds to Kilograms",
                    "Kilometers to Miles", "Miles to Kilometers",
                    "Liters to Gallons", "Gallons to Liters",
                    "Kilometers/hour to Miles/hour", "Miles/hour to Kilometers/hour",
                    "Celsius to Kelvin", "Kelvin to Celsius",
                    "Square meters to Square feet", "Square feet to Square meters",
                    "Hours to Minutes", "Minutes to Seconds",
                    "Joules to Calories", "Calories to Joules",
                    "Pascals to Atmospheres", "Atmospheres to Pascals",
                    "Grams to Ounces", "Ounces to Grams"
            };
            for (String op : convOps)
                operationCombo.addItem(op);
            input2Field.setEnabled(false);
            input2Field.setText("");
        }
    }

    private void performCalculation() {
        try {
            if (modeCombo.getSelectedItem().equals("Calculator")) {
                double a = Double.parseDouble(input1Field.getText());
                String op = (String) operationCombo.getSelectedItem();
                double res;
                if (op.matches("sqrt|log|sin|cos|tan|!|exp|abs|inv")) {
                    res = performUnaryCalc(op, a);
                } else {
                    double b = Double.parseDouble(input2Field.getText());
                    res = performBinaryCalc(op, a, b);
                }
                resultLabel.setText(String.format("Result: %.4f", res));
            } else {
                double val = Double.parseDouble(input1Field.getText());
                String conv = (String) operationCombo.getSelectedItem();
                double res = performConversion(conv, val);
                resultLabel.setText(String.format("Result: %.4f", res));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric inputs.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Calculation Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Calculator unary operations
    private double performUnaryCalc(String op, double a) {
        switch (op) {
            case "sqrt":
                if (a < 0)
                    throw new IllegalArgumentException("Cannot take square root of negative.");
                return Math.sqrt(a);
            case "log":
                if (a <= 0)
                    throw new IllegalArgumentException("Log undefined for zero or negative.");
                return Math.log10(a);
            case "sin":
                return Math.sin(Math.toRadians(a));
            case "cos":
                return Math.cos(Math.toRadians(a));
            case "tan":
                return Math.tan(Math.toRadians(a));
            case "!":
                if (a < 0 || a != (int) a)
                    throw new IllegalArgumentException("Factorial undefined for negative or non-integers.");
                return factorial((int) a);
            case "exp":
                return Math.exp(a);
            case "abs":
                return Math.abs(a);
            case "inv":
                if (a == 0)
                    throw new IllegalArgumentException("Inverse of zero undefined.");
                return 1 / a;
            default:
                throw new IllegalArgumentException("Unknown unary operator.");
        }
    }

    // Calculator binary operations
    private double performBinaryCalc(String op, double a, double b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new IllegalArgumentException("Cannot divide by zero.");
                return a / b;
            case "^":
                return Math.pow(a, b);
            case "%":
                if (b == 0)
                    throw new IllegalArgumentException("Cannot modulo by zero.");
                return a % b;
            default:
                throw new IllegalArgumentException("Unknown binary operator.");
        }
    }

    
    private double performConversion(String conv, double val) {
        switch (conv) {
            case "Celsius to Fahrenheit":
                return cToF(val);
            case "Fahrenheit to Celsius":
                return fToC(val);
            case "Meters to Feet":
                return mToFt(val);
            case "Feet to Meters":
                return ftToM(val);
            case "Kilograms to Pounds":
                return kgToLb(val);
            case "Pounds to Kilograms":
                return lbToKg(val);
            case "Kilometers to Miles":
                return kmToMiles(val);
            case "Miles to Kilometers":
                return milesToKm(val);
            case "Liters to Gallons":
                return litersToGallons(val);
            case "Gallons to Liters":
                return gallonsToLiters(val);
            case "Kilometers/hour to Miles/hour":
                return kmhToMph(val);
            case "Miles/hour to Kilometers/hour":
                return mphToKmh(val);
            case "Celsius to Kelvin":
                return cToK(val);
            case "Kelvin to Celsius":
                return kToC(val);
            case "Square meters to Square feet":
                return sqmToSqft(val);
            case "Square feet to Square meters":
                return sqftToSqm(val);
            case "Hours to Minutes":
                return hoursToMinutes(val);
            case "Minutes to Seconds":
                return minutesToSeconds(val);
            case "Joules to Calories":
                return joulesToCalories(val);
            case "Calories to Joules":
                return caloriesToJoules(val);
            case "Pascals to Atmospheres":
                return pascalsToAtm(val);
            case "Atmospheres to Pascals":
                return atmToPascals(val);
            case "Grams to Ounces":
                return gramsToOunces(val);
            case "Ounces to Grams":
                return ouncesToGrams(val);
            default:
                throw new IllegalArgumentException("Unknown conversion.");
        }
    }

    
    private double factorial(int n) {
        double f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
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

    public static double cToK(double c) {
        return c + 273.15;
    }

    public static double kToC(double k) {
        return k - 273.15;
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

    public static double caloriesToJoules(double cal) {
        return cal * 4.184;
    }

    public static double pascalsToAtm(double pascals) {
        return pascals / 101325;
    }

    public static double atmToPascals(double atm) {
        return atm * 101325;
    }

    public static double gramsToOunces(double g) {
        return g * 0.035274;
    }

    public static double ouncesToGrams(double oz) {
        return oz / 0.035274;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorConverterGUI::new);
    }
}
