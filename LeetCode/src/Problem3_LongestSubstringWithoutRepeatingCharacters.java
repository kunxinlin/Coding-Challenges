import java.util.*;

public class Problem3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" ")); //-> 1
        System.out.println(lengthOfLongestSubstring("a")); //-> 1
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb "));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("watermelon")); // rmelon->6
    }

    static int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int longest=0;
        //j is start index, i is end index
        for (int i=0, j=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                //we do +1 because we are getting the last index of the repeated character back and shifting the index
                //over 1 to the start of the new window
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            longest = Math.max(longest,i-j+1);
        }
        return longest;
    }

/*    //my first attempt, it's too inefficient
    static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int size  = 0;
        for(int i = 0 ;i<s.length(); i++){
            set.add(s.charAt(i));
            if(set.size() > size){
                size = set.size();
            }
            for(int j = i+1; j<s.length(); j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    if(set.size() > size){
                        size = set.size();
                    }
                }else{
                    set.clear();
                    break;
                }
            }
        }

        return size;
    }*/






}
