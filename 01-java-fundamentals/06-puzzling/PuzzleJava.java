import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class PuzzleJava {

    // Method #1 - Create Array, print sum and retun array.
    // Create an array with the following values: 3,5,1,2,7,9,8,13,25,32.
    // Print the sum of all numbers in the array. Also have the function return an array that only
    //  includes numbers that are greater than 10 (e.g. when you pass the array above, it should return 
    // an array with the values of 13,25,32)
    public static ArrayList<Integer> returnArray(int[] arValues){
      // int [] myArray1 = new int[] {3,5,1,2,7,9,8,13,25,32};  create on TEST side
      ArrayList<Integer> newArray = new ArrayList<Integer>();
      int sum=0;
      for (int i=0; i<arValues.length; i++){
        if (arValues[i] > 10) {
          newArray.add(arValues[i]); 
        }
        sum= sum + arValues[i];
      }
      System.out.println(sum);
      return newArray;
      // System.out.println(newArray);  //CANNOT just print a return ArrayList it needs size and get
    }

    //Method#2 - Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. 
    // Shuffle the array and print the name of each person. Have the method 
    // also return an array with names that are longer than 5 characters.
    public static ArrayList<String> retrnArrString(){
      ArrayList<String> namesReturn = new ArrayList<String>();
      ArrayList<String> names = new ArrayList<String>();
      names.add("Nancy");
      names.add("Jinichi");
      names.add("Fujibayashi");
      names.add("Momochi");
      names.add("Ishikawa");

      Collections.shuffle(names);  // shuffle names
      for (String i : names) {           //int i=0; i<names.length; i++
      System.out.println(i);
        if (i.length() > 5)  {   //longer than 5 characters
          namesReturn.add(i); 
        }
      }
      return namesReturn;  
    }
 
    //Method#3,4,5 -Create an array that contains all 26 letters of the alphabet (this array must have 26 values).
    //Shuffle the array and, after shuffling, display the last letter from the array.
    //Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.
    //Method 4,5 -random
    public static void theAlphabet(){
      Random r = new Random();
      ArrayList<Character>alphabet = new ArrayList<Character>();
      for (char ch = 'a'; ch <= 'z'; ++ch){
        alphabet.add(ch);
      }
      System.out.println(alphabet);  //before
      Collections.shuffle(alphabet);
      System.out.println(alphabet);  //after
      char first = alphabet.get(0); // find first element 
      char last = alphabet.get(alphabet.size() - 1); // find last element 
      // print first and last element of ArrayList 
      System.out.println("\nFirst : " + first + ", Last : " + last); 

      if(first =='a' || first=='e' || first=='i' || first=='o' || first=='u'){
        System.out.println("I am in First position and I am a vowel: " + first);
      }
                
      int randomnum = r.nextInt(26);
      System.out.println("This is a random letter: " + alphabet.get(randomnum));

    }   

    //Method#5 -Generate and return an array with 10 random numbers between 55-100 and have it be sorted
    //(showing the smallest number in the beginning). Display all the numbers in the array.
    //Next, display the minimum value in the array as well as the maximum value.
    //To sort a collection, you can use the sort method of the Collections class.
    public void random10() {
      ArrayList<Integer> rand10Array = new ArrayList<Integer>();
      int low = 55;
      int high = 100;
      Random r = new Random();

      for (int i = 0; i < 10; i++) {
          int onlyTen = r.nextInt(low) + (high-low); //between 55 -100
          rand10Array.add(onlyTen);
          System.out.println(onlyTen);  //before sorting
      }    
      Collections.sort(rand10Array); 
      System.out.println(rand10Array);  //after sorting

      System.out.println(rand10Array.get(0));  //smallest
      System.out.println(rand10Array.get(9)); //highest
    }



}