object Solution {
    
    def uniquePaths(y: Int, x: Int, ref: Array[Array[Int]], m: Int, n: Int): Int = {
        if(x == m || y == n) return 0
        else if(x == m - 1 && y == n - 1) return 1
        
        if(ref(y)(x) != 0){
            ref(y)(x)
        } else {
            val sum = uniquePaths(y+1, x, ref, m, n) + uniquePaths(y, x+1, ref, m, n)   
            ref(y)(x) = sum
            sum
        }
    }
    
    def uniquePaths(m: Int, n: Int): Int = {
        val ref: Array[Array[Int]] = Array.ofDim[Int](n, m)
        uniquePaths(0, 0, ref, m, n)
    }
}
