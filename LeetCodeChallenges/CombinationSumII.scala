import scala.collection.mutable._

object Solution {
    var res: Set[List[Int]] = Set()
    
    def combinationSum2Rec(candidates: List[Int], target: Int, acc: List[Int]): Unit = candidates match {
        case x::xs =>
            if(target - x < 0){
                combinationSum2Rec(xs, target, acc)
            } else if(target - x == 0){
                res.add((x::acc).sortWith((x: Int, y: Int) => x < y))
                combinationSum2Rec(xs, target, acc)
            } else {
                combinationSum2Rec(xs, target-x, x::acc)
                combinationSum2Rec(xs, target, acc)
            }
        case Nil => ()
    }
    
    def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
        combinationSum2Rec(candidates.toList, target, List())
        
        val result = res
        res = Set()
        
        result.toList
    }
}