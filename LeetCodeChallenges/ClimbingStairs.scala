import scala.collection.mutable.Map;

object Solution {
    def climbStairs(n: Int): Int = {
        val m: Map[Int, Int] = Map()
        
        def inner(curr: Int): Int = {
            if(curr == 0) return 1
            if(curr < 0) return 0
            
            m.get(curr) match {
                case None => {
                    val res: Int = inner(curr-1) + inner(curr-2)
                    m(curr) = res
                    res
                }
                case Some(v) => v
            }
        }
        
        inner(n)
    }
}
