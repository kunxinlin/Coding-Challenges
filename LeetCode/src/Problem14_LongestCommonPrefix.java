import java.util.Arrays;
/*Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".



        Example 1:

        Input: strs = ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.*/


public class Problem14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int longest = 0;
        String result = "";
        String first = strs[0];
        String last = strs[strs.length-1];

        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) == last.charAt(i)){
                result += first.charAt(i);
            }else{
                break;
            }
        }

        return result;
    }
}
