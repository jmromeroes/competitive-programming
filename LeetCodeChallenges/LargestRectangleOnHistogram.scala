import scala.util.control.Breaks._

object Solution {
    def largestRectangleArea(index: Int, heights: Array[Int], refArray: Array[Int]): Int = {
        var res = 1
        
        breakable {
            for(i <- index - 1 to 0 by -1){
                if(heights(i) > heights(index)){
                    res += 1
                } else if(heights(i) == heights(index)) {
                    return refArray(i)
                } else {
                    break
                }
            }
        }
        
        breakable {
            for(i <- index + 1 until heights.length){
                if(heights(i) >= heights(index)){
                    res += 1
                } else {
                    break
                }
            }
        }
        
        res
    }
    
    def largestRectangleArea(heights: Array[Int]): Int = {
        var res = 0
        val refArray: Array[Int] = Array.ofDim[Int](heights.length)
        
        for(i <- 0 until heights.length){
            val currentRes = largestRectangleArea(i, heights, refArray)
            refArray(i) = currentRes
            res = Math.max(res, refArray(i)*heights(i))
        }
        
        res
    }
}
