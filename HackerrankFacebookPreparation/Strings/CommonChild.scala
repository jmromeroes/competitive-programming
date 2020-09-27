def commonChild(s1: String, s2: String): Int = {
        val dp: Array[Array[Int]] = Array.ofDim[Int](s1.length+1, s1.length+1)

        for(y <- 1 to s1.length){
            for(x <- 1 to s2.length){
                var max = 0
                if(s1(x-1) == s2(y-1)){
                    max = Math.max(dp(y-1)(x), Math.max(dp(y)(x-1), dp(y-1)(x-1)+1))
                } else {
                    max = Math.max(dp(y-1)(x), dp(y)(x-1))
                }
                dp(y)(x) = max
            }
        }

        return dp(s1.length)(s1.length)
    }
