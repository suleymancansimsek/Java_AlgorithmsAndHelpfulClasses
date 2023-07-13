package RecursiveFactorial;
/*
 this class shows that how can we make recursive factorial method

 remainder for factorial:
  n! = n*(n-1)*(n-2)*...* 1
  ex: 5! = 5*4*3*2*1 = 120
 */
public class Factorial {
    //test method
    public static void main(String[] args) {
        int number = 5;
        System.out.println(factorial(5));
    }

    //factorial method with recursive algorithm
    public static int factorial(int n){
        //base case
        if (n <= 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
