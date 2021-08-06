import java.util.*;

public class Problem136_SingleNumber {
//    //my first take on how to solve it, not fast, since we have to sort it
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i += 2) {
//            if (nums[i] != nums[i + 1]) {
//                return nums[i];
//            }
//        }
//
//        return nums[nums.length - 1]; //we don't ever loop through this, so this has to be the answer
//    }


//    //most intuitive approach, but its actually slower than sort, its n^2
//    public int singleNumber(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//
//        for(var i : nums){
//            if(list.contains(i)){
//                list.remove((Integer)i); //need to cast it to an Integer Object, otherwise it remove by index
//                //new Integer(i) works too.
//            }else{
//                list.add(i);
//            }
//        }
//
//        return list.get(0);
//    }

    //fastest
    // a XOR a = 0
    // a XOR 0 = a
    // so we XOR all bits and the number that is left is the odd one out
    public int singleNumber(int[] nums) {
        int n = 0;
        for(int i : nums){
            n ^= i;
        }
        return n;
    }
}
