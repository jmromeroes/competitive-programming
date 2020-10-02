object Solution {
    def minDistance(word1: String, word2: String): Int = {        
        val dp: Array[Array[Int]] = Array.ofDim[Int](word2.length+1, word1.length+1);

        for(y <- 0 to word2.length){
            for(x <- 0 to word1.length){
                if(y == 0 || x == 0){
                    dp(y)(x) = Math.max(y, x);
                } else {
                    if(word2(y - 1) == word1(x - 1))
                        dp(y)(x) = dp(y-1)(x-1)
                    else
                        dp(y)(x) = Math.min(Math.min(dp(y-1)(x-1), dp(y)(x-1)), dp(y-1)(x)) + 1
                }
            }
        }
        
        return dp(word2.length)(word1.length)
    }
}
