object Solution {
    def longestPalindrome(s: String): String = {
        var maxLength = 1
        var res = ""
        var ref: Array[Array[Boolean]] = Array.ofDim[Boolean](s.length, s.length)
        
        for(i <- 0 until s.length){
            for(j <- 0 until (s.length - i)){
                if(i == 0){
                    ref(j)(j) = true
                    res = s(j).toString
                } else {
                    if(s(j) == s(j+i)) {
                        if(i == 1){
                            ref(j)(j+i) = true
                            res = s.slice(j, j+2)
                        } else if(ref(j+1)(j+i-1)){
                            ref(j)(j+i) = true
                            if(maxLength < i+1){
                                res = s.slice(j, j+i+1)
                            }
                        }
                    }
                }
            }
        }
        
        res
    }
}