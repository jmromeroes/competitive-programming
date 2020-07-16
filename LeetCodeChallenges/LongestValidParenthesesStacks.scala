import scala.collection.mutable._

object Solution {
    
    def longestValidParentheses(s: String): Int = {
        val parsStack: Stack[Char] = Stack()
        val indexStack: Stack[Int] = Stack()
        val map: Map[Int, Int] = Map()
        
        var max = 0
        var res = 0
        for(i <- 0 until s.length){
            val c: Char = s(i)
            if(c == '(') {
                parsStack.push(c)
                indexStack.push(i)
            } else if(parsStack.isEmpty  || parsStack.pop != '('){
                parsStack.clear
                indexStack.clear
                res = 0
            } else {
                val openIndex = indexStack.pop()
                
                val l = i - openIndex + 1
                
                map.get(openIndex - 1) match {
                    case None =>
                        map(i) = l
                    case Some(v) =>
                        map(i) = l + v
                }
                
                res = map(i)
                
                if(res > max){
                    max = res
                }
                
            }
        }
                      
        max
    }
}