package DiceRollingMeanValue;

import java.util.Random;
import java.util.Scanner;

 class DiceRoller {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // Kullanıcıdan zar atılacak sayısını ve istenen sayıyı al
        System.out.print("Kaç kere zar atılsın: ");
        int numRolls = sc.nextInt();
        System.out.print("İstenen sayı: ");
        int targetNumber = sc.nextInt();

        // Zar atılacak sayı kadar döngü çalıştır
        int count = 0;
        for (int i = 0; i < numRolls; i++) {
            // Zarı at
            int roll = rand.nextInt(6) + 1;

            // Eğer zar atışı istenen sayıyı verirse, sayacı bir arttır
            if (roll == targetNumber) {
                count++;
            }
        }

        // Ortalama sayıyı hesapla ve ekrana yazdır
        double average = (double) count / numRolls;
        System.out.println("İstenen sayı ortalama " + average + " kere geldi.");
    }
}