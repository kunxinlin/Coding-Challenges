/*Example 1:

        Input: digits = [1,2,3]
        Output: [1,2,4]
        Explanation: The array represents the integer 123.
        Example 2:

        Input: digits = [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.
        Example 3:

        Input: digits = [0]
        Output: [1]*/

public class Problem66_PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i = length -1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            //keep turning all the numbers to 0 until the next digit isn't a 9 which will then break out of the loop and return the digits
            digits[i] = 0;
        }

        //for case where all the digits is 9s, so the length of the digit will increase by 1
        //java default set all of them to 0
        //so we just need to change the first digit to a 1
        int[] allNines = new int [length+1];
        allNines[0] = 1;

        return allNines;
    }
}
