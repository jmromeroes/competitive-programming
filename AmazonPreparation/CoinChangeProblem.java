class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
       int[][] dp = new int[coins.length+1][amount+1];
       for(int coinIndex=1; coinIndex <= coins.length; coinIndex++){
           int coin = coins[coinIndex-1];

           for(int coinsAmount=1; coinsAmount <= amount; coinsAmount++){
                if(coinsAmount < coin){
                   dp[coinIndex][coinsAmount] = dp[coinIndex-1][coinsAmount];
                   continue;
                }
                
                if(coinsAmount == coin){
                    dp[coinIndex][coinsAmount] = 1;
                    continue;
                }
                
                int prevAmount = dp[coinIndex-1][coinsAmount];
                int prevComb = dp[coinIndex][coinsAmount - coin];
                if(prevAmount == 0){
                    dp[coinIndex][coinsAmount] = prevComb!=0?prevComb+1:0;
                } else {
                    if(prevComb == 0){
                        dp[coinIndex][coinsAmount] = dp[coinIndex-1][coinsAmount];
                    } else {
                        dp[coinIndex][coinsAmount] = 
                            Math.min(
                                dp[coinIndex][coinsAmount - coin]+1, dp[coinIndex-1][coinsAmount]
                            );
                    }
                }
               
           }
       }
        
       return dp[coins.length][amount]==0?-1:dp[coins.length][amount];
    }
}
