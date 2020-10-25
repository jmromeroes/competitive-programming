import scala.util.control.Breaks._

object Solution {
    
    def evaluateColumnAndRow(columnRef: Array[Array[Int]], col: Int, row: Int): Int = {
        var res = 1
        breakable {
            for(i <- col - 1 to 1 by -1){
                if(columnRef(row)(i) >= columnRef(row)(col)){
                    res += 1
                } else {
                    break;
                }
            }
        }
        
        breakable {
            for(i <- col + 1 until columnRef(0).length){
                if(columnRef(row)(i) >= columnRef(row)(col)){
                    res += 1
                } else {
                    break;
                }
            }
        }
        
        res
    }
    
    def maximalRectangle(matrix: Array[Array[Char]]): Int = {
        if(matrix.length == 0) return 0
        var res = 0
        
        var columnRef: Array[Array[Int]] = Array.ofDim[Int](matrix.length + 1, matrix(0).length + 1)
        
        for(y <- 0 until matrix.length){
            for(x <- 0 until matrix(0).length){
                if(matrix(y)(x) == '1')
                    columnRef(y+1)(x+1) = columnRef(y)(x + 1) + 1
            }
        }
        
        for(y <- 1 until columnRef.length){
            for(x <- 1 until columnRef(0).length){
                 val currResult = evaluateColumnAndRow(columnRef, x, y)
                 res = Math.max(res, currResult * columnRef(y)(x))
            }
        }
        
        res
    }
}
