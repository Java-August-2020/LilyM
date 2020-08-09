import java.util.ArrayList;
import java.util.Arrays;


public class BasicJava {

    // Method #1 - Print 1-255
    // Write a method that prints all the numbers from 1 to 255.
    public void print255(int num) {
      for (int i = 1; i <= num; i++) {
        System.out.println(i);
      }
    }

    // Method #2 - Print odd numbers between 1-255
    public void print255Odd(int num) {
      for (int i = 1; i <= num; i++) {
        if(i % 2 != 0 ) {
          System.out.println(i);
        }
      }
    }
  
    // Method #3 - Print Sum
    // Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers 
    // that have been printed so far. For example, your output should be something like this:
    // New number: 0 Sum: 0, New number: 1 Sum: 1, New number: 2 Sum: 3, 3=6, 255=___
    // Do NOT use an array to do this exercise.
    public void print255Sum(int num){
      int sum = 0;
      for(int i = 0; i<=num; i++){
        sum = sum + i;
        System.out.println(sum);
      }
    }

    // Method#4 -Iterating through an array
    // Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array
    // and print each value on the screen. Being able to loop through each member of the array is extremely important.
    public void iterateArray(int [] arValues){
      int x = 0;
      for(int i = 0; i<arValues.length; i++){
        x = arValues[i];
        System.out.println(x + " ");
      }
      //or FOR EACH LOOP
      //       for (int i : arValues) {          
      //           x = i; 
      //           System.out.print(x + " "); 
      //       } 
    }

    // Method#5 -Find Max
    // Write a method (sets of instructions) that takes any array and prints the maximum value in the array.
    // Your method should also work with a given array that has all negative numbers (e.g. [-3, -5, -7]), 
    // or even a mix of positive numbers, negative numbers and zero.
    public void findMax(int[] arValues){
      int max=0;
      for (int i=0; i<arValues.length; i++){
        if (arValues[i] > max){
          max = arValues[i];
        }
        // System.out.println(max + " ");
      }
      System.out.println(max + " ");
    }

    //Method#6 - Get Average
    //Write a method that takes an array, and prints the AVERAGE of the values in the array.
    //For example for an array [2, 10, 3], your method should print an average of 5. 
    //Again, make sure you come up with a simple base case and write instructions to solve that base case first, then test your instructions for other complicated cases.
    public void getAverage(int[] arValues){
      int avg = 0;
      int sum = 0;
      for (int i=0; i<arValues.length; i++){
        sum = sum + arValues[i];
      }
      avg = sum / arValues.length;
      System.out.println(avg);
    }

    //Method#7 - New Array with Odd Numbers
    //Write a method that creates an array 'y' that contains all the odd numbers between 1 to 255.
    //When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].
    public void newAryWithOddNum (){
      ArrayList<Integer> newArray = new ArrayList<Integer>();
      for (int i=1; i<=25; i++){
        if (i % 2 !=0 ) {
          newArray.add(i);
        }
      }
      System.out.println(newArray);
    }

    //Method#8 -Greater Than Y
    //Write a method that takes an array and returns the number of values in that array 
    //whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, 
    //after your method is run it will print 2 (since there are two values in the array that are greater than 3).
    public void numGrtrThanY(int[] arValues){
      int count=0;
      int y = 3;
      for (int i=0; i<arValues.length; i++){
        if (arValues[i] > y){
          count = count + 1;
        }
      }
      System.out.println(count);
    }

    //Method#9 - Square the values
    // Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself.
    //When the method is done, the array x should have values that have been squared, say [1, 25, 100, 4].
    public void squareValue(int[] arValues){
      ArrayList<Integer> newArray = new ArrayList<Integer>();
      for (int i=0; i<arValues.length; i++){
          newArray.add(arValues[i] * arValues[i]);
      }
      System.out.println(newArray);
    }

    //Method#10 - Eliminate Negative Numbers
    //Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0.
    //When the method is done, x should have no negative values, say [1, 5, 10, 0].
    public void replaceNegatives(int[] arValues){
      for (int i=0; i<arValues.length; i++){
        if(arValues[i] < 0){
          arValues[i] = 0;
        }
      }
      // System.out.println(arValues); This prints the address/pointer needs the toString conversion
      System.out.println(Arrays.toString(arValues));
    } 

    // Method#11 -Find Max, Min, and Average
    // Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number
    //in the array, the minimum value in the array, and the average of the values in the array.
    //The returned array should be three elements long and contain: [MAXNUM, MINNUM, AVG]

    public void findMaxMinAvg(int[] arValues){
      int max=0;
      int min=0;
      int sum=0;
      int avg=0;
      for (int i=0; i<arValues.length; i++){
        if (arValues[i] > max){
          max = arValues[i];
        }
        else if(arValues[i] < min){
          min = arValues[i];
        }
        sum = sum + arValues[i];
        avg = sum / arValues.length;
      }
      // avg = sum / arValues.length;
      System.out.println(max + " " + min + " " + avg);
    }

    // Method#12 -Shifting the Values in the Array
    // Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front.
    //For example, when the method is done, an x of [1, 5, 10, 7, -2] should become [5, 10, 7, -2, 0]. 
    // Notice that the last number is 0. The method does not need to wrap around the values shifted out of bounds.
    public void shiftArrValues(int[] arValues){
      int temp=arValues[0];
      for (int i=0; i<arValues.length-1; i++){
        arValues[i] = arValues[i+1];   
      }
      arValues[arValues.length-1]= temp;  //or just temp=0 to have 5,10,7,-2, 0
      
      System.out.println(Arrays.toString(arValues));
    }


}