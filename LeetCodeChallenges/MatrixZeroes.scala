object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        if(matrix.length == 0) return
        
        var isRow = false
        var isCol = false
        
        for(y <- 0 until matrix.length){
            for(x <- 0 until matrix(0).length){        
                if(matrix(y)(x) == 0){
                    if(y == 0) {
                        isRow = true
                    }
                    if(x == 0){
                        isCol = true   
                    }
                    
                    matrix(y)(0) = 0
                    matrix(0)(x) = 0
                }
            }
        }
        
        for(y <- 1 until matrix.length){
            for(x <- 1 until matrix(0).length){
                if(matrix(y)(0) == 0 || matrix(0)(x) == 0){
                    matrix(y)(x) = 0;
                }
            }
        }
        
        if(isRow){
            for(x <- 0 until matrix(0).length){
                matrix(0)(x) = 0
            }
        }
        
        if(isCol){
            for(y <- 0 until matrix.length){
                matrix(y)(0) = 0
            }
        }
    }
}
