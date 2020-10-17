object Solution {
    def subsets(list: List[Int]): List[List[Int]] = list match {
        case x::xs =>
            val resultRest: List[List[Int]] = subsets(xs)
            List(List(x)) ++ resultRest.map(x :: _) ++ resultRest
        case Nil =>
            List(List())
    }
    
    def subsets(nums: Array[Int]): List[List[Int]] = {
        val numsList: List[Int] = nums.toList
        subsets(numsList).toSet.toList
    }
}
