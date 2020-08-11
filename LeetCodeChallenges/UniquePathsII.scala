object Solution {
    
    def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]], col: Int, row: Int, ref: Array[Array[Int]], height: Int, width: Int): Int = {
        if(col == width || row == height || obstacleGrid(row)(col) == 1) return 0
        if(col == width - 1 && row == height - 1) return 1
        
        if(ref(row)(col) != 0){
            if(ref(row)(col) == -1) 0
            else ref(row)(col)
        } else {
            val pathsSum = uniquePathsWithObstacles(obstacleGrid, col + 1, row, ref, height, width) +
                           uniquePathsWithObstacles(obstacleGrid, col, row + 1, ref, height, width)
            ref(row)(col) = if(pathsSum == 0) -1 else pathsSum
            pathsSum
        }
    }
    
    def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
        if(obstacleGrid.length == 0 || obstacleGrid(0).length == 0) return 0
        
        val height = obstacleGrid.length
        val width = obstacleGrid(0).length
        
        val ref = Array.ofDim[Int](height, width)
        
        uniquePathsWithObstacles(obstacleGrid, 0, 0, ref, height, width)
    }
}
