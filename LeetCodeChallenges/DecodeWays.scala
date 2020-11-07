import scala.collection.mutable

object Solution {
    val m: Map[String, Char] = {
        for {
            c <- 'A' to 'Z'
        } yield {
            ((c - 'A' + 1).toString -> c)
        }
    }.toList.toMap
    
    val dp: mutable.Map[String, Int] = mutable.Map()
    
    def numDecodingsAux(s: String): Int = {
        var res = 0
        
        if(dp.contains(s)){
            return dp(s)
        }
        
        if(s.length <= 1){
            if(s != "0")
                return s.length
            else return 0
        }

        for(i <- 1 until Math.min(3, s.length + 1)){
            val left = s.substring(0, i)
            val right = s.substring(i, s.length)
            
            if(m.contains(left)){
                val recursionRes = numDecodingsAux(right)
                if(recursionRes > 0)
                    res += recursionRes
                else if(right.length == 0){
                    res += 1
                }
            }
        }
        
        dp(s) = res
        res
    }

    def numDecodings(s: String): Int = {
        if(s == "0") return 0
        return numDecodingsAux(s)
    }
}
