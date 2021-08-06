import java.util.*;

public class Problem17_LetterCombinationsofAPhoneNumber {
    public static void main(String[] args) {
        //System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        //System.out.println(letterCombinations("456"));

    }

    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();

        if(digits == null|| digits.length() == 0){
            return result;
        }

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        //string passed it is the current combination we are dealing with
        //pass in a index of where in the digit we are at
        letterCombinationsRecursive(result, digits, "", 0, mapping);

        return result;

    }

    public static void letterCombinationsRecursive(List<String> result, String digits, String currentCombo, int index, String[] mapping){
        if(index == digits.length()){
            result.add(currentCombo);
            return;
        }

        //ex. '5' - '0' -> 5 convert string literal into ints
        //or you can use. Character.getNumericValue
        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i<letters.length(); i++){
            //call the next combo, so digit +1 and we append the current letter to the current combo
            letterCombinationsRecursive(result, digits, currentCombo+letters.charAt(i), index +1, mapping);
        }
    }
}
