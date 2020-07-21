import scala.collection.mutable._

object Solution {
    var res: ListBuffer[List[Int]] = ListBuffer()
    
    def permute(nums: List[Int], set: Set[Int], acc: List[Int]): Unit  = {
        if(set.size == nums.length) res += acc
        
        for{
            num <- nums
            if !set.contains(num)
        } yield {
            permute(nums, set + num, num :: acc)
        }
    }
    
    def permute(nums: Array[Int]): List[List[Int]] = {
        permute(nums.toList, Set(), List())
        val result = res
        res = ListBuffer()
        result.toList
    }
}