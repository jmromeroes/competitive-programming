import scala.collection.mutable._

object Solution {
        
    def isMatch(s: String, p: String): Boolean = {
        val dp: Array[Array[Boolean]] = Array.ofDim[Boolean](s.length + 1, p.length + 1)
        
        dp(0)(0) = true
        
        var i: Int = 0
        
        while(i < p.length && dp(0)(i)){
            if(p(i) == '*') 
                dp(0)(i+1) = true
            i += 1
        }
        
        for {
            y <- 1 to s.length
            x <- 1 to p.length
        } yield {
            
            p(x-1) match {
                case '?' =>
                    dp(y)(x) = dp(y-1)(x-1)
                case '*' =>
                    dp(y)(x) = dp(y)(x-1) || dp(y-1)(x)
                case v => 
                    if(p(x-1) == s(y-1)){
                        dp(y)(x) = dp(y-1)(x-1)
                    }
            }
            
        }
        
        dp(s.length)(p.length)
    }
}