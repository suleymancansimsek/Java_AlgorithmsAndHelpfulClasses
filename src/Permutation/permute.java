package Permutation;

import java.util.Random;

public class permute
{
	public static void main(String [] args)
	{
		int array_size = 4;
		int [] array = new int[array_size];
		int [] frequency_array = new int[24];
		int permutation_index = 0;

		Random rand = new Random();

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);

		array[0] = 4;
		array[1] = 3;
		array[2] = 2;
		array[3] = 1;

		permutation_index = compute_permutation_index(array);

		System.out.printf("permutation index = %d\n", permutation_index);

		//Question 3 Part (a)

//		for (int i = 0; i < 24000; i++) {
//			randomize_in_place(array);
//
//			permutation_index = compute_permutation_index(array);
//			frequency_array[permutation_index]++;
//
//		}
//		print_array(frequency_array);

		//Question 3 Part (b)

		for (int i = 0; i < 24000; i++) {
			permute_with_all(array);

			permutation_index = compute_permutation_index(array);
			frequency_array[permutation_index]++;

		}
		print_array(frequency_array);

		//Question 1 Part (b)
		int array_size_2 = 10;
		int [] array_2 = new int[array_size_2];
		for (int i = 0; i < array_size_2; i++)
			array_2[i] = rand.nextInt(100);

		System.out.println("Original Array in Question 1: ");
		print_array(array_2);

		// for 5 output
		for (int i = 0; i < 5; i++){
			randomize_in_place(array_2);
			System.out.println(" after permutes " + (i+1) +" : ");
			print_array(array_2);
		}

		//Question 2 Part (b)
		int array_size_3 = 10;
		int [] array_3 = new int[array_size_3];
		for (int i = 0; i < array_size_3; i++)
			array_3[i] = rand.nextInt(100);

		System.out.println("Original Array in Question 2:");
		print_array(array_3);

		System.out.println("Permuted Array in Question 2:");
		permute_with_all(array_3);

		for (int i = 0; i < 5; i++){
			permute_with_all(array_3);
		}


	}


	//Implement randomize in place algorithm below
	public static void randomize_in_place(int[] array)
	{
		int index, temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--)
		{
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}



        //Implement permute with all algorithm below
        public static void permute_with_all(int[] array)
        {
			int index, temp;
			Random random = new Random();
			for (int i = array.length - 1; i > 0; i--)
			{
				index = random.nextInt(1, array.length);
				temp = array[index];
				array[index] = array[i];
				array[i] = temp;
			}
        }

	public static int compute_permutation_index(int [] A)
	{
		int permutation_index = 0;
		int next_number = 0;
		int index_next_number = 0;

		for (int starting_index = 0; starting_index < A.length-1; starting_index++)
		{	
			int [] remaining_numbers = new int [A.length-starting_index];
                        int [] remaining_numbers_sorted = new int [A.length-starting_index];

			for (int i = 0; i < remaining_numbers.length; i++)
			{
				remaining_numbers[i] = A[starting_index+i];
				remaining_numbers_sorted[i] = remaining_numbers[i];
			}

			insertion_sort(remaining_numbers_sorted);

			next_number = A[starting_index];

			for (int i = 0; i < remaining_numbers_sorted.length; i++)
			{
				if (remaining_numbers_sorted[i] == next_number)
				{
					index_next_number = i;
					break;
				}
			}

			permutation_index += index_next_number*factorial(remaining_numbers.length-1);	
		}	

		return permutation_index;
		
	}

	public static int factorial(int x)
	{	
		int product = 1;

		for (int i = x; i >= 1; i--)
			product *= i;

		return product;
	}

        public static void insertion_sort(int [] A)
        {
                int key;
                int i;

                for (int j = 1; j < A.length; j++)
                {
                        key = A[j];

                        //insert A[j] into the sorted sequence A[1..j-1]
                        i = j-1;

                        while ((i >= 0) && (A[i] > key))
                        {
                                A[i+1] = A[i];
                                i = i-1;
                        }

                        A[i+1] = key;
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

