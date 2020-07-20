import scala.collection.mutable._

object Solution {
    var res: Set[List[Int]] = Set()
    
    def combinationSumRecursion(candidates: List[Int], target: Int, acc: List[Int]): Unit = candidates match {
        case x::xs => 
                        
            if(target - x < 0){
                combinationSumRecursion(xs, target, acc)   
            } else if(target - x == 0){
                res.add((x::acc).sortWith((x: Int, y: Int) => x < y))
                combinationSumRecursion(xs, target, acc)
            } else {
                combinationSumRecursion(xs, target, acc)
                combinationSumRecursion(x::xs, target-x, x::acc)
            }
        case Nil => ()
    }
    
    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
        combinationSumRecursion(candidates.toList, target, List())
        val result = res.toList
        res = Set()
        
        result
    }
}