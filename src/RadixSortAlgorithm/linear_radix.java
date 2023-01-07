package RadixSortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class linear_radix
{
	public static void main(String [] args) {

		// Part (b)
		int[] B = new int[10];
		Random rand = new Random();
		for (int i = 0; i < B.length; i++) {
			B[i] = rand.nextInt(90) + 10;
		}

		// print the unsorted array
		System.out.println("Unsorted array:");
		for (int num : B) {
			System.out.print(num + " ");
		}
		System.out.println();

		// sort the array using radix sort
		radix_sort(B, B.length);

		// print the sorted array
		System.out.println("Sorted array:");
		for (int num : B) {
			System.out.print(num + " ");
		}
		System.out.println();

		//Part (c)
		int[] inputSizes = {10, 100, 1000, 10000, 100000, 1000000, 100000000};

		// create a table to store the running times
		long[][] times = new long[inputSizes.length][4];

		// measure the running time of each sorting algorithm for each input size
		for (int i = 0; i < inputSizes.length; i++) {
			int size = inputSizes[i];

			// create an array and initialize it with random numbers
			int[] A = new int[size];
			Random rando = new Random();
			for (int j = 0; j < A.length; j++) {
				A[j] = rando.nextInt(900) + 100;
			}

			// measure the running time of radix sort
			long startTime = System.nanoTime();
			radix_sort(A, A.length);
			long endTime = System.nanoTime();
			times[i][0] = endTime - startTime;

			// measure the running time of counting sort
			startTime = System.nanoTime();
			count_Sort(A, A.length);
			endTime = System.nanoTime();
			times[i][1] = endTime - startTime;

			// measure the running time of merge sort
			startTime = System.nanoTime();
			merge_sort(A, 0, size -1);
			endTime = System.nanoTime();
			times[i][2] = endTime - startTime;

			// measure the running time of heap sort
			startTime = System.nanoTime();
			heap_sort(A);
			endTime = System.nanoTime();
			times[i][3] = endTime - startTime;
		}

		// print the running times
		System.out.println("Input size\tRadix sort\tCounting sort\tMerge sort\tHeap sort");
		for (int i = 0; i < inputSizes.length; i++) {
			System.out.print(inputSizes[i] + "\t\t");
			for (int j = 0; j < 4; j++) {
				System.out.print(times[i][j] + "\t\t");
			}
			System.out.println();
		}


		// Part (d)
		/*
		int size = 100000000;
		int[] A = new int[size];
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(900) + 100;
		}


		// run radix sort
		long startTime = System.nanoTime();
		//radix_sort(A, A.length);
		//count_Sort(A, A.length);
		//merge_sort(A, 0 , size -1);
		heap_sort(A);
		long endTime = System.nanoTime();
		long runningTime = endTime - startTime;
		System.out.println("Radix sort running time: " + runningTime + " nanoseconds");

		/*


		// run counting sort
		startTime = System.nanoTime();
		count_Sort(A, A.length);
		endTime = System.nanoTime();
		runningTime = endTime - startTime;
		System.out.println("Counting sort running time: " + runningTime + " nanoseconds");

		// run merge sort
		startTime = System.nanoTime();
		merge_sort(A, 0 , size -1);
		endTime = System.nanoTime();
		runningTime = endTime - startTime;
		System.out.println("Merge sort running time: " + runningTime + " nanoseconds");

		// run heap sort
		startTime = System.nanoTime();
		heap_sort(A);
		endTime = System.nanoTime();
		runningTime = endTime - startTime;
		System.out.println("Heap sort running time: " + runningTime + " nanoseconds");
		*/

	}


	//Implement radix sort algorithm below
	static void radix_sort(int arr[], int n)
	{
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}


	// A utility function to get maximum value in arr[]
	static int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	static void countSort(int arr[], int n, int exp)
	{
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);


		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	static void count_Sort(int array[], int size) {
		int[] output = new int[size + 1];

		// Find the largest element of the array
		int max = array[0];
		for (int i = 1; i < size; i++) {
			if (array[i] > max)
				max = array[i];
		}
		int[] count = new int[max + 1];

		// Initialize count array with all zeros.
		for (int i = 0; i < max; ++i) {
			count[i] = 0;
		}

		// Store the count of each element
		for (int i = 0; i < size; i++) {
			count[array[i]]++;
		}

		// Store the cummulative count of each array
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}

		// Find the index of each element of the original array in count array, and
		// place the elements in output array
		for (int i = size - 1; i >= 0; i--) {
			output[count[array[i]] - 1] = array[i];
			count[array[i]]--;
		}

		// Copy the sorted elements into original array
		for (int i = 0; i < size; i++) {
			array[i] = output[i];
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

