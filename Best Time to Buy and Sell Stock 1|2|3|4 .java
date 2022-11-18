// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Best Time to Buy and Sell Stock :

class Solution {
    public int maxProfit(int[] prices) {
    int minprice = Integer.MAX_VALUE ;
    int maxprofit = 0 ;
        for(int i = 0 ; i < prices.length ; i++){
            if(prices[i]<minprice){
                minprice = prices[i];
            }
            else if(prices[i]-minprice > maxprofit){
                maxprofit = prices[i] - minprice ;
            }
        }
        return maxprofit ;
    }
} 
----------------------------------------------------------------------------------------------------------------------------------
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
Best Time to Buy and Sell Stock II :

class Solution {
    public int maxProfit(int[] prices) {
      int profit = 0 ;
        for(int i = 1 ; i<prices.length ; i++){
            if(prices[i]>prices[i-1]){
                profit += (prices[i]-prices[i-1]);
            }
        }
        return profit ;
    }
}
----------------------------------------------------------------------------------------------------------------------------------
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
Best Time to Buy and Sell Stock III :

----------------------------------------------------------------------------------------------------------------------------------
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
Best Time to Buy and Sell Stock IV :

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k>len/2) return solve(prices);
        
        int[][] t = new int[k+1][len];
        
        for(int i=1 ; i<=k ; i++){
            int tempmax = -prices[0];
            for(int j =1 ; j<len ; j++){
                t[i][j] = Math.max(t[i][j-1],prices[j]+tempmax);
                tempmax = Math.max(tempmax,t[i-1][j-1]-prices[j]);
          }
        }
        return t[k][len-1];
    }
    public int solve(int[] prices){
        int profit = 0;
        for(int i=1 ; i<prices.length ; i++){
           if(prices[i]>prices[i-1]){
             profit+=(prices[i]-prices[i-1]);
         }
     }
     return profit;
   }
}
