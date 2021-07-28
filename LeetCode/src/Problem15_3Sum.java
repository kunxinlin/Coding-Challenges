import java.util.*;

public class Problem15_3Sum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        //not >= cause it could be all zeros, ex. 0,0,0
        if(nums[0] > 0) return Collections.emptyList();//also returns empty list, except it's immutable

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            //we are always going to process the first index
            //it would throw an index out of bound too if we didn't
            //otherwise we skip, if the previous number was same, the first iteration of the particular number would give us all the matching pairs already
            //ex. -1,-1,0,1,2
            //1st iteration at (nums[0]= -1) -> [-1,-1,2] and [-1,0,1].
            //2nd iteration at (nums[1]= -1) -> [-1,0,1] we get a duplicate for this result.
            if (i == 0 || nums[i] != nums[i-1]) {
                //since we sorted it, the next lowest number is the one right after our current index
                //highest number at the end
                //subtract our current number from 0. and that is the target for the sum of the other 2 number.
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        //same as our first if, there may be the same repeated value
                        //so increment until next value isnt the same
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        //then actually increment to a different value
                        lo++; hi--;
                    }
                    else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
