package ArraySortvsInsertionSort;/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//package dsaj.arrays;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

  /** Insertion-sort of an array of characters into nondecreasing order */
  public static void insertionSort(int[] data) {
    int n = data.length;
    for (int k = 1; k < n; k++) {            // begin with second character
      int cur = data[k];                    // time to insert cur=data[k]
      int j = k;                             // find correct index j for cur
      while (j > 0 && data[j-1] > cur) {     // thus, data[j-1] must go after cur
        data[j] = data[j-1];                 // slide data[j-1] rightward
        j--;                                 // and consider previous j for cur
      }
      data[j] = cur;                         // this is the proper place for cur
    }
  }

  public static void insertionSortReverse(int[] data) {
    int n = data.length;
    for (int k = 1; k < n; k++) {            // begin with second character
      int cur = data[k];                    // time to insert cur=data[k]
      int j = k;                             // find correct index j for cur
      while (j > 0 && data[j-1] < cur) {     // thus, data[j-1] must go after cur
        data[j] = data[j-1];                 // slide data[j-1] rightward
        j--;                                 // and consider previous j for cur
      }
      data[j] = cur;                         // this is the proper place for cur
    }
  }
  public static void main(String[] args) {
    /*
    char[] a = {'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
    System.out.println(java.util.Arrays.toString(a));
    insertionSort(a);
    System.out.println(java.util.Arrays.toString(a));
    */

  int data[ ] = new int[256];
  Random rand = new Random( ); // a pseudo-random number generator
  //rand.setSeed(System.currentTimeMillis( )); // use current time as a seed
  rand.setSeed(1);

  // fill the data array with pseudo-random numbers from 0 to 99, inclusive
  for (int i = 0; i < data.length; i++)
        data[i] = rand.nextInt(100); // the next pseudo-random number
  int[ ] orig = Arrays.copyOf(data, data.length); // make a copy of the data array

  insertionSort(data);
  long startTime = System.nanoTime();
  insertionSort(data); // sorting the data array (orig is unchanged)
  long endTime = System.nanoTime();
  long elapsed = endTime-startTime;

  //System.out.println("orig = " + Arrays.toString(orig));
  //System.out.println("data = " + Arrays.toString(data));
//  System.out.println("elapsed time = " + elapsed);

    int array[ ] = new int[16];
    Random random = new Random( ); // a pseudo-random number generator
    //rand.setSeed(System.currentTimeMillis( )); // use current time as a seed
    random.setSeed(1);

    // fill the data array with pseudo-random numbers from 0 to 99, inclusive
    for (int i = 0; i < array.length; i++)
      array[i] = random.nextInt(100); // the next pseudo-random number

    startTime = System.nanoTime();
    insertionSort(array); // sorting the data array (orig is unchanged)
    endTime = System.nanoTime();
    elapsed = endTime-startTime;

    //System.out.println("orig = " + Arrays.toString(orig));
    //System.out.println("data = " + Arrays.toString(data));
    //System.out.println("elapsed time = " + elapsed);

    // Question 1 part b
    calculateAverage(16);
    calculateAverage(64);
    calculateAverage(256);
    calculateAverage(1024);
    calculateAverage(4096);

    System.out.println("\n");

    // Question 1 part c
    calculateAverageSorted(16);
    calculateAverageSorted(64);
    calculateAverageSorted(256);
    calculateAverageSorted(1024);
    calculateAverageSorted(4096);

    System.out.println("\n");

    // Question 1 part d
    calculateAverageDescending(16);
    calculateAverageDescending(64);
    calculateAverageDescending(256);
    calculateAverageDescending(1024);
    calculateAverageDescending(4096);




  }

  static long calculateAverage(int lenght){
    long startTime;
    long endTime;
    long elapsed = 0;
    long total = 0;
    for (int k = 0; k<10; k++){
      int array[ ] = new int[lenght];
      Random random = new Random( ); // a pseudo-random number generator
      //rand.setSeed(System.currentTimeMillis( )); // use current time as a seed
      random.setSeed(1);

      // fill the data array with pseudo-random numbers from 0 to 99, inclusive
      for (int i = 0; i < array.length; i++)
        array[i] = random.nextInt(100); // the next pseudo-random number

      startTime = System.nanoTime();
      insertionSort(array); // sorting the data array (orig is unchanged)
      endTime = System.nanoTime();
      elapsed = endTime-startTime;
      total += elapsed;
    }

    long average = total/10;

    //System.out.println("orig = " + Arrays.toString(orig));
    //System.out.println("data = " + Arrays.toString(data));
    System.out.println("average time for 10 times runnging Part(b) for length " + lenght + " = " + average);
    return average;
  }

  static long calculateAverageSorted(int lenght){
    long startTime;
    long endTime;
    long elapsed = 0;
    long total = 0;
    for (int k = 0; k<10; k++){
      int array[ ] = new int[lenght];
      Random random = new Random( ); // a pseudo-random number generator
      //rand.setSeed(System.currentTimeMillis( )); // use current time as a seed
      random.setSeed(1);

      // fill the data array with pseudo-random numbers from 0 to 99, inclusive
      for (int i = 0; i < array.length; i++)
        array[i] = random.nextInt(100); // the next pseudo-random number
      insertionSort(array);
      startTime = System.nanoTime();
      insertionSort(array); // sorting the data array (orig is unchanged)
      endTime = System.nanoTime();
      elapsed = endTime-startTime;
      total += elapsed;
    }

    long average = total/10;

    //System.out.println("orig = " + Arrays.toString(orig));
    //System.out.println("data = " + Arrays.toString(data));
    System.out.println("average time for 10 times runnging Part(c) for length " + lenght + " = " + average);
    return average;
  }

  static long calculateAverageDescending(int lenght){
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

      insertionSortReverse(array);
      startTime = System.nanoTime();
      insertionSort(array); // sorting the data array (orig is unchanged)
      endTime = System.nanoTime();
      elapsed = endTime-startTime;
      total += elapsed;
    }

    long average = total/10;

    //System.out.println("orig = " + Arrays.toString(orig));
    //System.out.println("data = " + Arrays.toString(data));
    System.out.println("average time for 10 times runnging Part(d) for length " + lenght + " = " + average);
    return average;
  }


}
