import scala.collection.mutable._

object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        if(intervals.length <= 1) return intervals
        
        val sortedIntervals = intervals.toList.sortWith((a, b) => a(0) < b(0))
        var max = sortedIntervals(0)(1)
        var min = sortedIntervals(0)(0)
        
        var res: ListBuffer[Array[Int]] = ListBuffer()
        
        for(i <- 1 until sortedIntervals.length){
            if(sortedIntervals(i)(0) <= max){
                max = Math.max(max, sortedIntervals(i)(1))
                min = Math.min(min, sortedIntervals(i)(0))
            } else {
                res += Array(min, max)
                max = sortedIntervals(i)(1)
                min = sortedIntervals(i)(0)
            }
        }
        res += Array(min, max)
        res.toArray
    }
}
