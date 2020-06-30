object Solution {
    
    def checkReverse(original: Int, res: Int): Int = {
        val originalStr = original.toString
        val resStr = res.toString
        val start = if(original < 0) 1 else 0
        
        if((original < 0 && res > 0) || (original > 0 && res < 0)){
            return 0
        }
        
        if(originalStr.length > resStr.length){
            return res
        }
        
        for(i <- start until originalStr.length){
            val subs = if(start == 1) i else i+1
            if(originalStr(i) != resStr(resStr.length - subs))
                return 0
        }
        
        res
    }
    
    def reverse(x: Int): Int = {
        var res = 0
        var xStr = x.toString
        var power = if(x < 0) -1 else 1
        var start = if(x < 0) 1 else 0
        
        if(xStr.length == 0) return 0
        
        for(i <- start until xStr.length){
            res += ((xStr(i) - '0') * power)
            power *= 10
        }
        
        checkReverse(x, res)
    }
    
}