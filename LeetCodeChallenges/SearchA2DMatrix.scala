object Solution {
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        if(matrix.length == 0) return false
        
        var start = 0
        var end = matrix(0).length * matrix.length - 1
        var mid = (start + end)/2
        
        while(start <= end){
            val curr: Int = matrix(Math.floor(mid / matrix(0).length).toInt)(mid % matrix(0).length)    
            if(curr == target)
                return true
            else if(start == end)
                return matrix(Math.floor(start / matrix(0).length).toInt)(start % matrix(0).length) == target
            else if(start == end - 1){
                return matrix(Math.floor(start / matrix(0).length).toInt)(start % matrix(0).length) == target ||
                    matrix(Math.floor(end / matrix(0).length).toInt)(end % matrix(0).length) == target
            } else if(curr < target){
                start = mid
            } else {
                end = mid
            }
            
            mid = (start + end)/2
        }
        
        return false;
    }
}
