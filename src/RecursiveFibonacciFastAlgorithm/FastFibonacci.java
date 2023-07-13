package RecursiveFibonacciFastAlgorithm;

import java.util.Arrays;
/*
This is the fast algorithm for implementing fibonacci series in Java.
İf we want to make fast fibonacci implementation we have to use cache
for data. So we can reuse the data.
 */
public class FastFibonacci {

    static int number = 100; // nTH fibonacci number
    static long[] fibonacciCache = new long[number + 1]; // we store the elements of fibonacci in the long array

    public static void main(String[] args) {
        // 1, 1, 2, 3, 5, 8, 13, 21, ... fibonacci remainder

        System.out.println(fibonacci(number)); // print nTH number on the screen
        System.out.println(Arrays.toString(fibonacciCache)); // print the array which stores the fibonacci elements
    }

    //fibonacci recursive function
    static long fibonacci(int n){
        //base case
        if (n <= 1){
            return n;
        }
        // use the element if the element is not zero
        if (fibonacciCache[n] != 0){
            return fibonacciCache[n];
        }

        long nThFibonacciNumber = fibonacci(n -1) + fibonacci(n - 2); // fibonacci function
        fibonacciCache[n] = nThFibonacciNumber; // store the element in the array

        return nThFibonacciNumber; // return it
    }
}
