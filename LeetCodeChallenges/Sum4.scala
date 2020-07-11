import scala.collection.immutable._

object Solution {
    def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
        var res: Set[List[Int]] = Set()
        
        def innerSum(currentIndex: Int, acc: List[Int], sum: Int, numberOfValues: Int):Unit = {
            if(currentIndex >= nums.length || numberOfValues > 3) return
            
            val curr: Int = nums(currentIndex)
            
            if(curr + sum == target && numberOfValues == 3)
                res += (curr :: acc).sortWith((x, y) => x > y)                
            else 
                innerSum(currentIndex+1, curr :: acc, sum + curr, numberOfValues+1)
            
            innerSum(currentIndex+1, acc, sum, numberOfValues)
        }
        
        innerSum(0, List(), 0, 0)
        res.toList
    }
}