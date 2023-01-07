package TriangleTrick;
import java.util.Random;

class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;
    private Random random = new Random();

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public void addPoint(Point p1, Point p2) {
        // Add a point between p1 and p2
        Point newPoint = p1.midpoint(p2);
        if (p1.isSmaller(p2)) {
            // Insert the new point between p1 and p2
            if (p1.isSmaller(newPoint) && newPoint.isSmaller(p2)) {
                p2 = newPoint;
            }
        } else {
            // Insert the new point between p2 and p1
            if (p2.isSmaller(newPoint) && newPoint.isSmaller(p1)) {
                p1 = newPoint;
            }
        }
    }

    public Point chooseRandomPoint() {
        // Choose a random point from p1, p2, and p3
        int choice = random.nextInt(3);
        if (choice == 0) {
            return p1;
        } else if (choice == 1) {
            return p2;
        } else {
            return p3;
        }
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point midpoint(Point other) {
        // Return the midpoint between this point and the other point
        double x = (this.x + other.x) / 2;
        double y = (this.y + other.y) / 2;
        return new Point(x, y);
    }

    public boolean isSmaller(Point other) {
        // Return true if this point is smaller (in terms of x and y values) than the other point, false otherwise
        if (this.x < other.x || (this.x == other.x && this.y < other.y)) {
            return true;
        } else {
            return false;
        }
    }
}
