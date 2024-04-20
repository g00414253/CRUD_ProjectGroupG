package org.example;

import java.util.InputMismatchException;

public class RepMax {
    public static void RM() {
        try {
            // Input weight lifted and reps done
            double weight = InputUtils.readDouble("Enter weight in Kg: ");
            int reps = InputUtils.readInt("Enter number of reps performed: ");

            // Calculation for 1RM
            double oneRepMax = calculateOneRepMax(weight, reps);

            // Display the results
            System.out.print("Estimated 1RM: " + oneRepMax + "kgs");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            RM(); // Recursive call to retry input
        }
    }

    public static double calculateOneRepMax(double weight, int reps) {
        double result = weight * (1 + reps / 30.0);
        return Math.round(result * 100.0) / 100.0;
    }
}
