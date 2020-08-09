public class BasicJavaTest {
    public static void main(String[] args) {
         
        BasicJava iD = new BasicJava();
        //Method #1 - Print 1-255
        // BasicJava iD = new BasicJava();
        int num = 25;
        iD.print255(num);
        
        // Method #2 - Print odd numbers between 1-255
        // BasicJava iD2 = new BasicJava();
        iD.print255Odd(num);

        // Method #3 - Print sum  1-255
        iD.print255Sum(num);         

        // Method#4 -Iterating through an array
        int[] myArray = {1,3,5,7,9,13};
        iD.iterateArray(myArray);   

        // Method#5 -Find Max
        int[] myArray2 = {1,0,5,-7,-9,13};
        iD.findMax(myArray2);   

        // Method#6 -Get Average
        int[] myArray3 = {2,10,3};
        iD.getAverage(myArray3);   

        // Method#7 - New Array with Odd Numbers
        iD.newAryWithOddNum();    

        //Method#8 -Greater Than Y
        int[] myArray4 = {1,3,5,7};
        iD.numGrtrThanY(myArray4);  

        //Method#9 - Square the values
        int[] myArray5 = {1,5,10,-2};
        iD.squareValue(myArray5);  

        //Method#10 - Replace negative#s with 0.
        int[] myArray6 = {1,5,10,-2};
        iD.replaceNegatives(myArray6);  
        // System.out.println(myArray6);
        // System.out.println(Arrays.toString(myArray6));

        // Method#11 -Find Max, Min, and Average
        int[] myArray7 = {1,5,10,-2};
        iD.findMaxMinAvg(myArray7);  

        // Method#12 -Shifting the Values in the Array
        int[] myArray8 = {1, 5, 10, 7, -2};
        iD.shiftArrValues(myArray8);  

    }
}


