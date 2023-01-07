package ArrayQueue;

public class ReverseStackTest {
    public static void main(String[] args) {
        // Create a Stack with the elements (1, 2, 3, 4, 5)
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack);

        // Create an empty queue
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        // Reverse the stack using the queue
        while (!stack.isEmpty()) {
            // Pop the top element from the stack
            int element = stack.pop();

            // Enqueue the element in the queue
            queue.enqueue(element);
        }

        // Dequeue the elements from the queue and push them back to the stack
        while (!queue.isEmpty()) {
            // Dequeue the element from the queue
            int element = queue.dequeue();

            // Push the element back to the stack
            stack.push(element);
        }

        // Print the reversed stack
        System.out.println(stack); // should print [5, 4, 3, 2, 1]
    }
}
