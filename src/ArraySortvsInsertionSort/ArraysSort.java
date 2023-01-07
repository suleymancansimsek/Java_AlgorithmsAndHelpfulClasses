package ArraySortvsInsertionSort;

import java.util.Arrays;
import java.util.Random;

/** Program showing some array uses. */
public class ArraysSort { 

public static void main(String[ ] args) { 

  int data[ ] = new int[4096];
  Random rand = new Random( ); // a pseudo-random number generator
  rand.setSeed(System.currentTimeMillis( )); // use current time as a seed
  
  // fill the data array with pseudo-random numbers from 0 to 99, inclusive
  for (int i = 0; i < data.length; i++)
  	data[i] = rand.nextInt(100); // the next pseudo-random number
  int[ ] orig = Arrays.copyOf(data, data.length); // make a copy of the data array

  long startTime = System.nanoTime();  
  Arrays.sort(data); // sorting the data array (orig is unchanged)
  long endTime = System.nanoTime();
  long elapsed = endTime-startTime;

//  System.out.println("orig = " + Arrays.toString(orig));
//  System.out.println("data = " + Arrays.toString(data));
//  System.out.println("elapsed time = " + elapsed);

  // Question 1 part e
  calculateAverageArrayMethod(16);
  calculateAverageArrayMethod(64);
  calculateAverageArrayMethod(256);
  calculateAverageArrayMethod(1024);
  calculateAverageArrayMethod(4096);
 }
  static long calculateAverageArrayMethod(int lenght){
    long startTime;
    long endTime;
    long elapsed = 0;
    long total = 0;
    int array[ ] = new int[lenght];

    for (int k = 0; k<10; k++){
      Random random = new Random( ); // a pseudo-random number generator
      //rand.setSeed(System.currentTimeMillis( )); // use current time as a seed
      random.setSeed(1);

      // fill the data array with pseudo-random numbers from 0 to 99, inclusive
      for (int i = 0; i < array.length; i++)
        array[i] = random.nextInt(100); // the next pseudo-random number

      startTime = System.nanoTime();
      Arrays.sort(array); // sorting the data array (orig is unchanged)
      endTime = System.nanoTime();
      elapsed = endTime-startTime;
      total += elapsed;
    }

    long average = total/10;

    //System.out.println("orig = " + Arrays.toString(orig));
    //System.out.println("data = " + Arrays.toString(data));
    System.out.println("average time for 10 times runnging Part(e) for length " + lenght + " = " + average);
    return average;
  }
}
