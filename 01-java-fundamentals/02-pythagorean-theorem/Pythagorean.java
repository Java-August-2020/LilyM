// // importing the Math class
import java.lang.Math;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double hypotenuse; 
        
        // calling the sqrt static method of the Math class
        hypotenuse = Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
        
        return hypotenuse;
    }
}
