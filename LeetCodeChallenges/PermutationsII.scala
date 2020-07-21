import scala.collection.mutable._

object Solution {
    var res: Set[List[Int]] = Set()
    
    def permuteUnique(l: Int, set: Set[Int], acc: List[Int]): Unit = {
        if(acc.length == l) res += acc
        
        for {
            i <- 0 until l
            if !set.contains(i)
        } yield {
            permuteUnique(l, set + i, i :: acc)
        }
    }
    
    def permuteUnique(nums: Array[Int]): List[List[Int]] = {
        val l = nums.length
        
        permuteUnique(l, Set(), List())
        val result = res
        
        res = Set()
        result.map(_.map(index => nums(index))).toList
    }
}