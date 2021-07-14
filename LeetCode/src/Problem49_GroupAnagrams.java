//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//        Example 1:
//
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//        Example 2:
//
//        Input: strs = [""]
//        Output: [[""]]
//        Example 3:
//
//        Input: strs = ["a"]
//        Output: [["a"]]


import java.util.*;

public class Problem49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(var s: strs){
            char[] chs  = s.toCharArray();
            Arrays.sort(chs);

            String key = String.valueOf(chs);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
