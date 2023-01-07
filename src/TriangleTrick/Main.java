package TriangleTrick;

import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points to add: ");
        int numPoints = scanner.nextInt();

        // Create an initial triangle with three random points
        Triangle triangle = new Triangle(new Point(Math.random(), Math.random()),
                new Point(Math.random(), Math.random()),
                new Point(Math.random(), Math.random()));

        // Add points to the triangle according to the rules described in the question
        for (int i = 0; i < numPoints; i++) {
            Point p1 = triangle.chooseRandomPoint();
            Point p2 = triangle.chooseRandomPoint();
            Point midpoint = p1.midpoint(p2);
            triangle.addPoint(p1, midpoint);

            Point p3 = triangle.chooseRandomPoint();
            Point midpoint2 = p3.midpoint(midpoint);
            triangle.addPoint(p3, midpoint2);
        }
    }
}
