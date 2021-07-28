public class Problem53_MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{1}));
    }

//    //brute force shitty solution
//    static public int maxSubArray(int[] nums){
//        if(nums.length ==1 ) return nums[0];
//
//        int max = nums[0];
//
//        for(int i = 0; i< nums.length; i++){
//            int sum = nums[i];
//            max = Math.max(max, sum);
//            for(int j = i+1; j< nums.length; j++){
//                sum+= nums[j];
//                max = Math.max(max, sum);
//            }
//        }
//
//        return max;
//    }

    //O(n)
    static public int maxSubArray(int[] nums){
        int largestSum = nums[0];
        int currentSum = largestSum;
        for(int i = 1; i<nums.length; i++){
            //start a new sum, if the previous continuous sum + current index is smaller than current index number.
            currentSum = Math.max(currentSum+nums[i], nums[i]);
            largestSum = Math.max(currentSum, largestSum);
        }

        return largestSum;
    }
}
