import java.util.Arrays;

public class Problem322_CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 0; i<=amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    //1 to simulate us taking that one piece of coin
                    //current amount - the value of the coin = what's left we need to fill
                    //when amount = the current value  we get 0 + 1 which is the base case for that amount
                    //which we stored already/built up, the least amount of coins we need + the current piece we taking
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }else{
                    break;
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
