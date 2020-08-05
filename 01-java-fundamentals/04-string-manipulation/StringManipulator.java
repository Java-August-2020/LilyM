
public class StringManipulator {
    
    // Method #1 - Trim both input strings and then concatenate them.
    // Return the new string. Feel free to use the trim method of the String class.
    public String trimAndConcat(String one, String two){
      String concat = one.trim() + two.trim();
      return concat;
    }

    // Method #2 - Get the index of the character and return either the index or null.
    // If the character appears multiple times, return the first index.
    //  Feel free to use the indexOf method of the String class.
    public Integer getIndexOrNull(String myString, char myChar){
        int result = myString.indexOf(myChar);
        return result;
    }

    // Method#3
    // Get the index of the start of the substring and return either the index or null.
    // Feel free to use the indexOf method of the String class.
    public Integer getIndexOrNull(String myString1, String myString2){
      int result2 = myString1.indexOf(myString2);
      return result2;
  }

    // Method#4
    // Get a substring using a starting and ending index, 
    // and concatenate that with the second string input to our method.
    // Feel free to use the substring method of the String class.
    //REMEMBER:  start is included but end it is not (eg., 1 3 it will include 1and2)!
    public String concatSubstring(String myString1, int start, int end, String myString2){
      String str =  myString1.substring(start, end);
      String str2 = myString2.substring(start, end);
      return str.concat(str2);
    }


}