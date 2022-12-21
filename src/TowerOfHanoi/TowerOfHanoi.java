package TowerOfHanoi;

/*
https://en.wikipedia.org/wiki/Tower_of_Hanoi
*/

public class TowerOfHanoi {
    public static void Tower_of_Hanoi(int n, char from_peg, char to_peg, char temp_peg) {
        // base case
        if (n == 0) return;

        // move n-1 disks from from_peg to temp_peg using to_peg as temporary storage
        Tower_of_Hanoi(n-1, from_peg, temp_peg, to_peg);

        // move the nth disk from from_peg to to_peg
        System.out.println("Move disk " + n + " from peg " + from_peg + " to peg " + to_peg);

        // move n-1 disks from temp_peg to to_peg using from_peg as temporary storage
        Tower_of_Hanoi(n-1, temp_peg, to_peg, from_peg);
    }

    public static void main(String[] args) {
        int n = 4; // number of disks
        Tower_of_Hanoi(n, 'a', 'c', 'b');
    }
}
