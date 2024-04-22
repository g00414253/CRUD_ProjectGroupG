package org.example;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    // Method to safely read an integer from the user
    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return value;
    }

    // Method to safely read a double from the user
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        return value;
    }

    // Method to safely read a string from the user
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Method to safely read a boolean from the user
    public static boolean readBoolean(String prompt) {
        System.out.print(prompt);
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                    System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    }
}