package QuickSortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class quick
{
	public static void main(String [] args)
	{
		int array_size = 67108864;
		int [] array = new int[array_size];
		long start_time, end_time, quickSortTime = 0, elapsed_time_insertion, elapsed_time_merge , elapsed_time;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);


// part d (looking the ram usage )

//		start_time = System.nanoTime();
//		heap_sort(array);
//		end_time = System.nanoTime();
//		elapsed_time = end_time - start_time;
//		System.out.printf("Elapsed time in nanoseconds for heap sort: %d\n", elapsed_time);
//
//		System.exit(1);
//
//                start_time = System.nanoTime();
//                merge_sort(array, 0, array_size-1);
//                end_time = System.nanoTime();
//                elapsed_time = end_time - start_time;
//				System.out.printf("Elapsed time in nanoseconds for merge sort: %d\n", elapsed_time);
//
//		start_time = System.nanoTime();
//		quickSort(array,0,array.length -1);
//		end_time = System.nanoTime();
//		elapsed_time = end_time - start_time;
//		System.out.printf("Elapsed time in nanoseconds for quick sort: %d\n", elapsed_time);
//
//		System.exit(1);

		//part b
		// Initialize the array with random numbers from 0 to 99
		Random random = new Random();
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}
		System.out.println("Original array: " + Arrays.toString(arr));  // Original array

		// Sort the array using quick sort
		quick.quickSort(arr, 0, arr.length - 1);

		System.out.println("Sorted array: " + Arrays.toString(arr));  // Sorted array



		//part c
		// Test the sort algorithms with different input sizes
		for (int i = 1; i <= 13; i++) {
			// Compute the input size (a power of 4)
			int size = (int) Math.pow(4, i);
			// Initialize the array with random numbers from 0 to 99
			Random random2 = new Random();
			int[] arr2 = new int[size];
			for (int j = 0; j < arr2.length; j++) {
				arr2[j] = random2.nextInt(100);
			}
			
			if (size> 262144){
				System.out.println("ı can not show the quick sort time because it is giving stack over flow error but this if else block can be solve the problem now");
			}else{
				// Measure the running time of quick sort
				start_time = System.nanoTime();
				quick.quickSort(arr2, 0, arr2.length - 1);
				 end_time = System.nanoTime();
				 quickSortTime = end_time - start_time;
			}


			// Measure the running time of heap sort
			start_time = System.nanoTime();
			heap_sort(arr2);
			end_time = System.nanoTime();
			long heapSortTime = end_time - start_time;

			// Measure the running time of merge sort
			start_time = System.nanoTime();
			merge_sort(arr2, 0, arr2.length - 1);
			end_time = System.nanoTime();
			long mergeSortTime = end_time - start_time;

			// Print the results
			System.out.println("Input size: " + size);
			System.out.println("Quick sort time: " + quickSortTime + " ns");
			System.out.println("Heap sort time: " + heapSortTime + " ns");
			System.out.println("Merge sort time: " + mergeSortTime + " ns");
			System.out.println();
		}
	}
	


	//part a
	//Implement partition algorithm below
	public static int partition(int[] arr, int low, int high)
	{
		// Choose the first element as the pivot
		int pivot = arr[low];
		// Set the left and right pointers
		int left = low;
		int right = high;
		// While the pointers have not crossed each other
		while (left < right) {
			// Move the right pointer to the left until it finds an element smaller than the pivot
			while (left < right && arr[right] >= pivot) {
				right--;
			}
			// Move the left pointer to the right until it finds an element larger than the pivot
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			// Swap the elements at the left and right pointers
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		// Swap the pivot with the element at the left pointer
		arr[low] = arr[left];
		arr[left] = pivot;
		// Return the pivot index
		return left;
	}

	//Implement randomized partition algorithm below
	public static int randomizedPartition(int[] arr, int low, int high) {
		// Choose a random pivot index
		Random rand = new Random();
		int pivotIndex = low + rand.nextInt(high - low + 1);
		// Swap the pivot element with the first element
		int pivot = arr[pivotIndex];
		arr[pivotIndex] = arr[low];
		arr[low] = pivot;
		// Use the regular partition method to partition the array around the pivot
		return partition(arr, low, high);
	}
	
	//Implement randomized quick sort algorithm below
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// Partition the array and get the pivot index
			int pivotIndex = randomizedPartition(arr, low, high);
			// Sort the elements before the pivot
			quickSort(arr, low, pivotIndex - 1);
			// Sort the elements after the pivot
			quickSort(arr, pivotIndex + 1, high);
		}
	}


	//assumes that index i starts from 1
	public static int parent(int i)
	{
		return (int)Math.floor(i/2);
	}

        //assumes that index i starts from 1
	public static int left(int i)
	{
		return 2*i;
	}

        //assumes that index i starts from 1
	public static int right(int i)
	{
		return (2*i+1);
	}

        //assumes that index i starts from 1
	public static void max_heapify(int [] A, int array_size, int i)
	{
		int left_index, right_index, index_of_largest;
		int temp;

		left_index = left(i);
                right_index = right(i);

		if ((left_index <= array_size) && (A[left_index-1] > A[i-1]))
			index_of_largest = left_index;
		else
			index_of_largest = i;

		if ((right_index <= array_size) && (A[right_index-1] > A[index_of_largest-1]))
			index_of_largest = right_index;

		if (index_of_largest != i)
		{
			temp = A[i-1];
			A[i-1] = A[index_of_largest-1];
			A[index_of_largest-1] = temp;
			max_heapify(A, array_size, index_of_largest);
		}
	}

	public static void build_max_heap(int [] A)
	{
		int middle_index = (int)Math.floor(A.length/2);
		int array_size = A.length;

		for (int i = middle_index; i >= 1; i--)
			max_heapify(A, array_size, i);
	}

	public static void heap_sort(int [] A)
	{
		int temp;
		int array_size = A.length;
		build_max_heap(A);
		
		for (int i = A.length; i >= 2; i--)
		{
			temp = A[0];
			A[0] = A[i-1];
			A[i-1] = temp;
			array_size--;
			max_heapify(A, array_size, 1);
		}
	}

	//indices p and r can start from 0
	public static void merge_sort(int [] A, int p, int r)
	{
		int q;

		if (p < r)
		{
			q = (int)Math.floor((p+r)/2);
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}

	public static void merge(int [] A, int p, int q, int r)
	{
		int n1, n2;
		int i, j;

		n1 = q-p+1;
		n2 = r-q;

		int [] L = new int[n1];
		int [] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = A[p+i];

                for (i = 0; i < n2; i++)
                        R[i] = A[q+i+1];		

		i = 0;
		j = 0;
		
		for (int k=p; k <= r; k++)
		{
			if (i >= n1) //the left array finished, copy from right array
			{
				A[k] = R[j];
				j++;
				continue;
			}
			
			if (j >= n2) //the right array finished, copy from left array
			{
				A[k] = L[i];
				i++;
				continue;
			}
	
			if (L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
		} 
	}	

        //prints the elements of the array A on the screen
        public static void print_array(int [] A)
        {       
                System.out.printf("[");
                for (int i = 0; i < A.length-1; i++)
                {       
                        System.out.printf("%d, ", A[i]);
                }
                
                System.out.printf("%d]\n", A[A.length-1]);
        
        }
}


