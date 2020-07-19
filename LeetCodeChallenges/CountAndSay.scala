import scala.annotation.tailrec

object Solution {
    
    def generateTextForNumber(text: String): String = {
        var i = 0
        var res = ""
        while(i < text.length){
            val c = text(i)

            var j = 0
            while(i < text.length && text(i) == c){
                j += 1
                i += 1
            }
            
            res += j.toString + c.toString
        }
        
        res
    }
    
    @tailrec
    def countAndSay(target: Int, curr: Int, prevText: String): String = {
        if(target == curr)
            generateTextForNumber(prevText)
        else 
            countAndSay(target, curr+1, generateTextForNumber(prevText))
    }
    
    def countAndSay(n: Int): String = {
        if(n == 1) "1"
        else if(n == 2) "11"
        else countAndSay(n, 3, "11")
    }
}