/*        Example 1:

        Input: s = "III"
        Output: 3
        Example 2:

        Input: s = "IV"
        Output: 4
        Example 3:

        Input: s = "IX"
        Output: 9
        Example 4:

        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.
        Example 5:

        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.*/

import java.util.*;

public class Problem13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);

            }};

        char[] arr = s.toCharArray();
        int num = 0;

        //if the previous roman numeral is small it means its the special cases
        //so we need to subtract it from the bigger numeral that comes after it
        //and again since we added it
        for(int i = 0; i<arr.length; i++){
            if(i> 0 && map.get(arr[i-1]) < map.get(arr[i])){
                num -= 2*map.get(arr[i-1]);
            }

            num += map.get(arr[i]);
        }

        return num;
    }
}
