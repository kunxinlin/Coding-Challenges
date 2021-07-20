package CrackingTheCodingInterview.StringsArraysQuestions;

import java.util.HashSet;
import java.util.Set;

public class p4_PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
        System.out.println(isPermutationOfPalindrome("aab"));
        System.out.println(isPermutationOfPalindrome("abc"));
        System.out.println(isPermutationOfPalindrome("careRac"));
    }

    //case insensitive
    //space insensitive
    static boolean isPermutationOfPalindrome(String s){
        Set<Character> set = new HashSet<>();

        for(char c :s.replaceAll("\s", "").toLowerCase().toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }

        if(set.size() > 1){
            return false;
        }

        return true;
    }
}
