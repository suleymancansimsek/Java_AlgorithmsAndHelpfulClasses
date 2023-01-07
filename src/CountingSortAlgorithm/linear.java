package CountingSortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class linear
{
	public static void main(String [] args)
	{

		//part (b)
		// Initialize the input array with random numbers from 0 to 9
		int[] Arr = new int[11];
		Random random = new Random();
		for (int i = 1; i <= 10; i++) {
			Arr[i] = random.nextInt(10);
		}


		int[] Brr = new int[11];
		int[] Crr = new int[10];

		// Sort the array using the counting sort algorithm
		counting_sort(Arr, Brr, Crr, 9);

		// Print the sorted array
		System.out.print("Sorted array: ");
		for (int i = 1; i <= 10; i++) {
			System.out.print(Brr[i] + " ");
		}
		System.out.println();


		//part (c) and part(d) in here
		// Set the input sizes
		int[] sizes = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

		// Initialize the arrays to store the running times
		long[] countingSortTimes = new long[sizes.length];
		long[] mergeSortTimes = new long[sizes.length];
		long[] heapSortTimes = new long[sizes.length];

		// Run the sorting algorithms for each input size
		for (int i = 0; i < sizes.length; i++) {
			// Initialize the input array with random numbers from 0 to size - 1
			int size = sizes[i];
			int[] A = new int[size + 1];
			Random rand = new Random();
			for (int j = 1; j <= size; j++) {
				A[j] = rand.nextInt(size);
			}

			// Initialize the output and auxiliary arrays
			int[] B = new int[size + 1];
			int[] C = new int[size];

			// Record the starting time
			long startTime = System.nanoTime();

			// Sort the array using the counting sort algorithm
			counting_sort(A, B, C, size - 1);

			// Record the ending time and store the running time
			long endTime = System.nanoTime();
			countingSortTimes[i] = endTime - startTime;

			// Initialize the input array for merge sort
			int[] D = new int[size];
			for (int j = 0; j < size; j++) {
				D[j] = A[j + 1];
			}

			startTime = System.nanoTime();

			// Sort the array using the merge sort algorithm
			merge_sort(D, 0, size - 1);

			endTime = System.nanoTime();
			mergeSortTimes[i] = endTime - startTime;

			// Initialize the input array for heap sort
			int[] E = new int[size];
			for (int j = 0; j < size; j++) {
				E[j] = A[j + 1];
			}


			startTime = System.nanoTime();

			// Sort the array using the heap sort algorithm
			heap_sort(E);

			endTime = System.nanoTime();
			heapSortTimes[i] = endTime - startTime;
		}

		// Print the running times
		System.out.println("Input size\tCounting sort\tMerge sort\tHeap sort");
		for (int i = 0; i < sizes.length; i++) {
			System.out.println(sizes[i] + "\t\t" + countingSortTimes[i] + "\t\t" + mergeSortTimes[i] + "\t\t" + heapSortTimes[i]);
		}
	}
	


	//Implement counting sort algorithm below
	public static void counting_sort(int[] A, int[] B, int[] C, int k) {
		for (int i = 0; i < k; i++) {
			C[i] = 0;
		}
		for (int j = 1; j <= A.length - 1; j++) {
			C[A[j]] = C[A[j]] + 1;
		}
		for (int i = 1; i <= k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		for (int j = A.length - 1; j >= 1; j--) {
			B[C[A[j]]] = A[j];
			C[A[j]] = C[A[j]] - 1;
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


