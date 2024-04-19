package org.example;

import java.util.Scanner;
public class BMRCalculator {

    public static void BMI() {
        Scanner scanner = new Scanner(System.in);

        // Input weight
        System.out.print("Enter your weight in kg: ");
        double weight = scanner.nextDouble();

        // Input height
        System.out.print("Enter your height in feet: ");
        int feet = scanner.nextInt();
        System.out.print("Enter your height in inches: ");
        int inches = scanner.nextInt();

        // Convert height to meters
        double heightInMeters = convertToMeters(feet, inches);

        // Calculate BMI
        double bmi = calculateBMI(weight, heightInMeters);

        // Display BMI
        System.out.print("Your BMI is: ");

        // Interpret BMI
        interpretBMI(bmi);
    }

    // Method to convert feet to meters
    public static double convertToMeters(int feet, int inches) {
        double totalInches = feet * 12 + inches;
        return totalInches * 0.0254;
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Method to interpret BMI
    public static void interpretBMI(double bmi) {
        if (bmi < 18.5) {
            System.out.println("You are underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Your weight is normal (healthy)");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("You are overweight");
        } else {
            System.out.println("You are obese");
        }
    }
}
