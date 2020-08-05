public class StringManipulatorTest {
    public static void main(String[] args) {
       
        StringManipulator manipulator = new StringManipulator();
        // Method#1
        // StringManipulator manipulator = new StringManipulator();
        String h = "    Hello     ";
        String w = "     World    ";
        String str = manipulator.trimAndConcat(h, w);
        System.out.println(str); // HelloWorld 

        // Method#2
        // StringManipulator manipulator = new StringManipulator();
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        // Method#3
        // StringManipulator manipulator = new StringManipulator();
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer p = manipulator.getIndexOrNull(word, subString);
        Integer q = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(p); // 2
        System.out.println(q); // null

        // Method#4
        // StringManipulator manipulator = new StringManipulator();
        String word2 = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word2); // eworld


    }
}

