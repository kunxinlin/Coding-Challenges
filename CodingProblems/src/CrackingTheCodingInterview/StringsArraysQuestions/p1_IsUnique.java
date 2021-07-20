package CrackingTheCodingInterview.StringsArraysQuestions;

/*Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?*/

public class p1_IsUnique {

    public static void main(String[] args) {
        System.out.println(isUniqueChars("apple"));
        System.out.println(isUniqueChars("ABCxyz"));

        System.out.println(isUniqueChars2("apple"));
        System.out.println(isUniqueChars2("ABCDEFGxyz"));
    }


    /*for this implementation we assume an ascii 0-127
    * so we just create an array of 128 booleans and flag it when we loop thought the string*/
    static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {//Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /*could also compare every char of the string to every other character, wouldn't be as efficient*/
    static boolean isUniqueChars2(String str) {
        if (str.length() > 128) return false;

        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j< str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
