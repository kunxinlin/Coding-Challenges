public class Problem9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }

    public static boolean isPalindrome(int x){
//         String string = Integer.toString(x);
//         StringBuilder sb = new StringBuilder(string);
//         sb.reverse();

//         System.out.println(sb);
//         System.out.println(string);
//         return string.equals(sb.toString());

        // Special cases:
        // when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.

        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        //keep reverting until x is no longer bigger than rev
        //that means it's either equal or less than, which means we processed half the numbers
        while (x>rev){
            //%10 to get the last digit
            //*10 of the previous number to get the reverted digit. 1*10 + 2 = 12
            rev = rev*10 + x%10;
            x = x/10; //remove the last digit from the original number ex. 1221/10 = 122
        }
        //1221 -> 12 == 12
        //12321 -> rev =123-> 12 == 12
        return (x==rev || x==rev/10); //middle digit don't matter, get rid of it by /10. ex. 123->12
    }
}
