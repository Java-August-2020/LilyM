public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz iD = new FizzBuzz();
        for (int i = 1; i <= 30; i++) {
            String result = iD.fizzBuzz(i);
            System.out.println("Number " + i + " - " + " Result: " + result);
        }
    }
}


//we could have called this from the main method like: fizzBuzzTest();
// public static void fizzBuzzTest() {
//     for (int i = 1; i <= 100; i++) {
//       String result = fizzBuzz(i);
//       System.out.println("Number " + i + " - " + " Result: " + result);
//     }
//   }
// }