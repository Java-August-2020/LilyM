import java.util.ArrayList;

public class PuzzleJavaTest {
    public static void main(String[] args) {
         
        PuzzleJava iD = new PuzzleJava();

        //Method #1 - createArray, printSum, returnArray
        // BasicJava iD = new BasicJava();
        int [] myArray1 = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> holdResult = iD.returnArray(myArray1);
        for (int i=0; i<holdResult.size(); i++){    //ArrayList needs .size() not .length
            System.out.println(holdResult.get(i));
        }

        // Method #2 - Print odd numbers between 1-255
        // BasicJava iD2 = new BasicJava();
        ArrayList<String> holdResult2 = iD.retrnArrString();
        for (int i=0; i<holdResult2.size(); i++){    //ArrayList needs .size() not .length
            System.out.println(holdResult2.get(i));
        }

        //Method#3,4,5 -
        iD.theAlphabet();   

        //Method#5 -Random 10
        iD.random10();   
       
    }
}


