package CrackingTheCodingInterview.StringsArraysQuestions;

import java.util.Arrays;

public class p2_Permutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("abcd", "badc"));
        System.out.println(isPermutation("dog", "god"));
        System.out.println(isPermutation("apple", "cherry"));

        System.out.println(isPermutation2("abcd", "badc"));
        System.out.println(isPermutation2("dog", "god"));
        System.out.println(isPermutation2("apple", "cherry"));

    }

    //simple, cleaner implementation
    static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char[] str1 = s1.toCharArray();
        Arrays.sort(str1); //sort is a void function

        char[] str2 = s2.toCharArray();
        Arrays.sort(str2);

        //Arrays.equal is different from str1.equals(str2) -> checks for the reference
        return Arrays.equals(str1, str2);
    }


    //more efficient implementation
    //check for identical character count
    static boolean isPermutation2(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        int[] letters = new int[128]; //assuming standard ASCII character count

        //turn first array into ch array and then add it to the count
        char[] s1Array = s1.toCharArray();
        for(char c: s1Array){
            letters[c]++;
        }

        for(int i = 0; i < s2.length(); i++){
            int c = (int) s2.charAt(i); //convert the char into its respective int representation
            letters[c]--; //decrement the current character from the s1 char array
            //if theres more of particular character count the count will be negative from the s1 char array
            if(letters[c] < 0){
                return false;
            }
        }

        return true;
    }
}
