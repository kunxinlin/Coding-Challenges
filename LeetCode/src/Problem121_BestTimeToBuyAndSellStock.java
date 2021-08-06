/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        Example 2:

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.*/

public class Problem121_BestTimeToBuyAndSellStock {

/*    //brute force
    //too slow
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i< prices.length-1; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }

        return max;
    }*/

    //one pass
    //keep a min variable to keep track of the lowest price and see if subsequent price have greater difference
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min = prices[0];
        for(int i = 0; i< prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else if(prices[i] - min > max_profit){
                max_profit = prices[i] - min;
            }
        }

        return max_profit;
    }
}
