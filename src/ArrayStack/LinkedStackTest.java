package ArrayStack;

import java.util.Stack;

public class LinkedStackTest {

    public static <E extends Object> void transfer(Stack<E> S, Stack<E> T){
        E tmp;
        System.out.println("Stack S Contents: ");
        while(!S.isEmpty()){
            tmp = S.pop();
            T.push(tmp);
            System.out.println(tmp);

        }         System.out.println();
    }

    public static void main(String[] args) {

        Stack<Integer> T = new Stack<>();
        Stack<Integer> S = new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);
        S.push(5);
        transfer(S, T);
        System.out.println("\nStack T Contents:");
        while(!T.isEmpty()){
            System.out.println(T.pop());
        }
    }
}
