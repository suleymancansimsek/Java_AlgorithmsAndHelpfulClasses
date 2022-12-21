package MaxSubArray;

import java.util.Arrays;

// program that finding maximum sub array by Süleyman Can Şimşek
public class MaxSubArray {
    public static int[] maxSubarray(int[] A) {
        // Initialize variables
        int max_sum = A[0]; // maximum subarray sum seen so far
        int curr_sum = A[0]; // current subarray sum
        int left_index = 0; // left index of the maximum subarray seen so far
        int right_index = 0; // right index of the maximum subarray seen so far

        // Iterate through the array
        for (int i = 1; i < A.length; i++) {
            // Determine the maximum subarray sum ending at index i
            curr_sum = Math.max(curr_sum + A[i], A[i]);
            // If the current subarray sum is greater than the maximum subarray sum seen so far, update the maximum subarray sum and indices
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                right_index = i;
            }
        }

        // Find the left index of the maximum subarray
        int sum = max_sum;
        for (int i = right_index; i >= 0; i--) {
            sum -= A[i];
            if (sum == 0) {
                left_index = i;
                break;
            }
        }

        // Return the maximum subarray
        return Arrays.copyOfRange(A, left_index, right_index + 1);
    }

    public static void main(String[] args) {
        int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] result = maxSubarray(A);

        System.out.println("The maximum subarray is: " + Arrays.toString(result));
        System.out.println("The sum of the maximum subarray is: " + Arrays.stream(result).sum());
    }

}
