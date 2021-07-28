//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Output: Because nums[0] + nums[1] == 9, we return [0, 1].


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
/*    public int[] twoSum(int[] nums, int target) {
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    num1 = i;
                    num2 = j;
                }
            }
        }

        return new int[]{num1, num2};
    }*/

    //faster O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            //ex. [1,1] -> 2
            //dont have to worry about same keys, since we only need a pair
            //when we get to the second number we just return the index of its complement and current index.
            if(map.containsKey(complement)){
                return new int []{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
