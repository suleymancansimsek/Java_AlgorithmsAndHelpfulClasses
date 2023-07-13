package RecursiveFibonacciSeries;
/*
this class shows that how can we make recursive fibonacci algorithm

remainder for fibonacci series :
 F(n) = F(n-1) + F(n-2)
 1,1,2,3,5,8,13,21 ...
 */
public class Fibonacci {
    public static void main(String[] args) {
        int number = 5; //nTh FİBONACCİ NUMBER

        System.out.println(fibonacci(number));
    }

    //recursive fibonacci method
    public static int fibonacci(int n){
        //base case
        if (n <= 1){
            return n;
        }
        return fibonacci(n -1) + fibonacci(n - 2);
    }
}
