package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Operationen calculator = new Operationen();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wähle eine Operation: add, sub, mul, div, exit");
            String operation = scanner.nextLine();

            if (operation.equals("exit")) {
                break;
            }

            double num1 = getValidDouble(scanner, "Erste Zahl: ");
            double num2 = getValidDouble(scanner, "Zweite Zahl: ");

            double result = 0;
            boolean validOperation = true;

            switch (operation) {
                case "add":
                    result = calculator.add(num1, num2);
                    break;
                case "sub":
                    result = calculator.subtract(num1, num2);
                    break;
                case "mul":
                    result = calculator.multiply(num1, num2);
                    break;
                case "div":
                    try {
                        result = calculator.divide(num1, num2);
                    } catch (ArithmeticException e) {
                        System.out.println("Fehler: " + e.getMessage());
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Ungültige Operation.");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("Ergebnis: " + result);
            }
        }
    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
            }
        }
        return value;
    }



    }
}