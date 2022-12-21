package DiceRollingMeanValue;

import java.util.Random;
import java.util.Scanner;

/* Simple Java program to calculate mean value when dice rolling many times.
For ex: you roll dice 1000 times and you wonder how many times 3 or 5 in the dice fac.
 */
class DiceRoller {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("How many times to roll the dice: ");
        int numRolls = sc.nextInt();
        System.out.print("requested number: ");
        int targetNumber = sc.nextInt();

        // loop for times of dicee
        int count = 0;
        for (int i = 0; i < numRolls; i++) {
            // roll
            int roll = rand.nextInt(6) + 1;

            // if number holds increase the counter one
            if (roll == targetNumber) {
                count++;
            }
        }

        // calculate the mean value
        double average = (double) count / numRolls;
        System.out.println("The requested number is average " + average + " times.");
    }
}