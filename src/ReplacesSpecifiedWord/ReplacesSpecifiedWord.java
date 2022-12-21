package ReplacesSpecifiedWord;

import java.util.Scanner;

/*
this program helps to changing the word in the text.
it is very simple and helpful to understand java basics

Süleyman Can Şimşek
 */
public class ReplacesSpecifiedWord {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // Read the text and the words to replace
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.nextLine();
        System.out.print("Enter the new word: ");
        String newWord = scanner.nextLine();

        // Replace the old word with the new word in the text
        String modifiedText = text.replace(oldWord, newWord);

        // Print the modified text
        System.out.println("Modified text: " + modifiedText);
    }
}
