import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

        If target is not found in the array, return [-1, -1].

        You must write an algorithm with O(log n) runtime complexity.



        Example 1:

        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
        Example 2:

        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]
        Example 3:

        Input: nums = [], target = 0
        Output: [-1,-1]*/
public class Problem34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};

        int index = 0, start = 0, end = nums.length-1;

        // <= because its inclusive otherwise it might skip an element
        while(start <= end){
            //good practice, to avoid potential overflow
            int mid = start + (end - start)/2;
            //even when we find an element equal to the target, we keep decreasing the end(high) pointer which will keep moving the midpoint left till the midpoint is less then the target or endpoint is lower than start which will exit out of the while loop, either way the last stored result is the leftmost index.
            if(nums[mid] == target){
                result[0] = mid;
                end = mid -1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        //we got the leftmost point, so we just need to reset the end
        //and increment the starting point till its greater than target or start is greater than end which will exit the loop
        end = nums.length - 1;
        while(start <= end && nums[start] == target){
            result[1] = start++;
        }

        return result;
    }

/*    //trivial solution using ArrayList, slower too
    public int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> al = IntStream.of(nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        return new int[]{al.indexOf(target), al.lastIndexOf(target)};
    }*/
}
