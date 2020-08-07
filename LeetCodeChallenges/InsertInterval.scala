import scala.collection.mutable._

object Solution {
    def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
        if(intervals.length == 0) return Array(newInterval)
        
        val sortedIntervals: List[Array[Int]] = (newInterval :: intervals.toList).sortWith((a, b) => a(0) < b(0))
        
        var min = sortedIntervals(0)(0)
        var max = sortedIntervals(0)(1)
        val res: ListBuffer[Array[Int]] = ListBuffer()
        
        for(i <- 1 until sortedIntervals.length){
            if(sortedIntervals(i)(0) <= max){
                max = Math.max(sortedIntervals(i)(1), max)
                min = Math.min(sortedIntervals(i)(0), min)
            } else {
                res += Array(min, max)
                min = sortedIntervals(i)(0)
                max = sortedIntervals(i)(1)
            }
        }
        
        res += Array(min, max)
        res.toArray
    }
}
