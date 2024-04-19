package org.example;

import java.util.Scanner;

public class RepMax {
    public static void RM() {
        Scanner scanner = new Scanner(System.in);

        // Input weight lifted and reps done
        System.out.print("Enter weight lifted in Kg: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter reps performed: ");
        int reps = scanner.nextInt();

        // Calculation for 1RM
        double oneRepMax = calculateOneRepMax(weight, reps);

        // Display the results
        System.out.print("Estimated 1RM: " + oneRepMax + "kgs");
    }

    public static double calculateOneRepMax(double weight, int reps) {
        double result = weight * (1 + reps / 30.0);
        return Math.round(result * 100.0) / 100.0;
    }
}
