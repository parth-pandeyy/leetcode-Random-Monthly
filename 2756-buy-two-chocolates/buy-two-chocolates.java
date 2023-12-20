class Solution {
    public int buyChoco(int[] prices, int money) {
        int FirstMinCost = Integer.MAX_VALUE;
        int SecondMinCost = Integer.MAX_VALUE;

        for(int p : prices){
            if(p < FirstMinCost){
                SecondMinCost = FirstMinCost;
                FirstMinCost = p ;
            }
            else{
                SecondMinCost = Math.min(SecondMinCost,p);
            }
        }
        int leftOver = money - (FirstMinCost + SecondMinCost);

        return leftOver >= 0 ? leftOver : money;
    }
}