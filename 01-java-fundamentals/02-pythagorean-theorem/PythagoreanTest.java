public class PythagoreanTest {
    public static void main( String[] args) {
        int x = 10;
        int y = 20;
        Pythagorean iD = new Pythagorean();
        double result = iD.calculateHypotenuse(x,  y);
        System.out.println("The length of hypotenuse is: "+ result);
    }
}
