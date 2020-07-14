import scala.collection.mutable._

object Solution {
    def checkRange(start: Int, e: Int, referenceMap: Map[Int, Int]): Boolean = {
        var i = start
        
        while(referenceMap.contains(i)){
            i = referenceMap(i) + 1
            if(i == e+1) return true
        }    
        
        false
    }
    
    def longestValidParentheses(s: String): Int = {
        if(s.length <= 1) return 0
        
        val dp: Array[Array[Boolean]] = Array.ofDim[Boolean](s.length, s.length)
        var res = 0
        val referenceMap: Map[Int, Int] = Map()
        
        for(wSize <- 1 until s.length by 2){
            for(index <- 0 until s.length){
                if(index+wSize < s.length && s(index) == '(' && s(index+wSize) == ')'){
                    if((index+1 >= index+wSize-1) || dp(index+1)(index+wSize-1) || checkRange(index, index+wSize, referenceMap)){
                        dp(index)(index+wSize) = true
                        referenceMap(index) = index+wSize
                        res = wSize
                    }
                }
            }
        }
        
        if((res+1) % 2 == 0) res + 1 else 0
    }
}