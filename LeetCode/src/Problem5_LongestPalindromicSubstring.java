public class Problem5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new Problem5_LongestPalindromicSubstring().longestPalindrome("babad")); //since we are making non static calls
        System.out.println(new Problem5_LongestPalindromicSubstring().longestPalindrome("cbbd"));
        System.out.println(new Problem5_LongestPalindromicSubstring().longestPalindrome("a"));
        System.out.println(new Problem5_LongestPalindromicSubstring().longestPalindrome("ac"));
        System.out.println(new Problem5_LongestPalindromicSubstring().longestPalindrome("racecar"));

    }

    private int start, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, so the starting index for left and right will be the same
            extendPalindrome(s, i, i+1); //for even length
        }
        //substring cuts off before the length so just need to pass in length+the index it started at
        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        // >= 0 because we have to check if index 0 and last index is also equal, which happens after the decrement
        //so after that left will be -1 and/or right will be +1 out of bound
        //therefore we need to +1 to left
        //and -1 to the length we get
        //and the left and right index is the same character (which makes an palindrome)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        //if its bigger than our current maxLen, we set the new maxLen and its starting index
        if (maxLen < right - left - 1) {
            start = left+1;
            maxLen = right - left - 1;
        }
    }
}
