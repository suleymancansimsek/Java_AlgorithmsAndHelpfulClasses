package Poisson_Distribution_Calculator;

import java.util.Scanner;

//Poisson Distribution Calculator (Probablity and Statistics)
 class PoissonDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the rate at which events occur (lambda) and the number of events (k)
        System.out.print("Enter the rate at which events occur (lambda): ");
        double lambda = scanner.nextDouble();
        System.out.print("Enter the number of events (k): ");
        int k = scanner.nextInt();

        // Calculate the probability of k events occurring using the Poisson distribution formula
        double probability = Math.exp(-lambda) * Math.pow(lambda, k) / factorial(k);

        // Print the result
        System.out.println("Probability of " + k + " events occurring: " + probability);
    }

    // Method to calculate the factorial of a number (n!)
    public static double factorial(int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}