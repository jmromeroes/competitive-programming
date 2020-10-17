import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set
  
object Solution {    
    
    def combine(l: List[Int]): List[List[Int]] = {
        l match {
            case x::Nil =>
                List(List(x))
            case x::xs =>
                val restResult: List[List[Int]] = combine(xs)
                val secondResult = restResult.map(x::_)
                secondResult ++ restResult ++ List(List(x))
            case Nil =>
                List(List())
        }          
    }
    
    def combine(n: Int, k: Int): List[List[Int]] = {
        val res = combine((1 to n).toList).filter(_.length == k)
        res
    }
}
