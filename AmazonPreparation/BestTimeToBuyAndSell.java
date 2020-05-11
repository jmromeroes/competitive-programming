class Solution {
    
    public int maxProfit(int[] prices, int currentIndex, int minimumPrice, int maximumProfit){
        if(currentIndex >= prices.length){
            return maximumProfit;
        }
        int currentPrice = prices[currentIndex];
        
        if(currentPrice < minimumPrice){
            minimumPrice = currentPrice;
        } 
        
        if(currentPrice - minimumPrice > maximumProfit){
            maximumProfit = currentPrice - minimumPrice;
        }
        
        return maxProfit(prices, currentIndex+1, minimumPrice, maximumProfit);
    }
    
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        
        return maxProfit(prices, 1, prices[0], 0); 
    }
}
