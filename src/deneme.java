import java.util.Scanner;

public class deneme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the height of the drone camera
        System.out.print("Enter the height of the drone camera (in meters): ");
        double height = scanner.nextDouble();

        // Calculate the radius of the circular area that the drone camera can see
        double radius = Math.tan(Math.toRadians(45)) * height;

        // Calculate the area of the circular area that the drone camera can see
        double area = Math.PI * radius * radius;

        // Print the result
        System.out.println("The drone camera can see an area of " + area + " square meters.");
    }
}