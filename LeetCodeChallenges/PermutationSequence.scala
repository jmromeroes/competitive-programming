import scala.collection._

object Solution {
    def getPermutation(n: Int, k: Int): String = {
        var currentIteration: Int = 0
        var result: String = null
        
        def inner(set: SortedSet[Int], acc: String): Unit = {
            if(set.size == 1){
                currentIteration += 1
                if(result == null && currentIteration == k) result = acc + set.toList(0).toString
                return
            } 
            if(currentIteration >= k) return
            
            for(i <- set){
                inner(set - i, acc + i.toString)
            }
        }
        
        val l: List[Int] = (1 to n).toList
        
        inner(SortedSet(l:_*), "")
        result
    }
}
