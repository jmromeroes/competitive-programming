import scala.collection.mutable._

object Solution {
    var blockReference: Map[String, Array[Boolean]] = Map()
    var colReference: Array[Array[Boolean]] = Array.ofDim[Boolean](9,9)
    var rowReference: Array[Array[Boolean]] = Array.ofDim[Boolean](9,9)
    
    def createInitialReferences(board: Array[Array[Char]]): Unit = {
        for {
            yBlock <- 0 until 3
            xBlock <- 0 until 3
            y <- 0 until 3
            x <- 0 until 3
        } yield {
            
            
            val row = 3*yBlock + y
            val col = 3*xBlock + x
            
            if(board(row)(col) != '.'){
                val value = (board(row)(col) - '0').toInt - 1

                blockReference.get(s"${yBlock}-${xBlock}") match {
                    case None =>
                        blockReference(s"${yBlock}-${xBlock}") = Array.ofDim[Boolean](9)
                        blockReference(s"${yBlock}-${xBlock}")(value) = true
                    case Some(array) => 
                        array(value) = true
                }

                colReference(col)(value) = true
                rowReference(row)(value) = true
            }
        }
        
    }
    
    def validateSudoku(col: Int, row: Int, value: Int): Boolean = {
        val yBlock = Math.floor(row/3).toInt
        val xBlock = Math.floor(col/3).toInt
                
        val invalidBlock: Boolean = blockReference.get(s"${yBlock}-${xBlock}") match {
            case None => 
                blockReference(s"${yBlock}-${xBlock}") = Array.ofDim[Boolean](9)
                false
            case Some(array) =>
                array(value-1)
        }

        val isValid = !(invalidBlock || colReference(col)(value-1) || rowReference(row)(value-1))
        return isValid 
    }
    
    def solveSudokuRecursion(col: Int, row: Int, board: Array[Array[Char]]): Boolean = {
        if(row == 9) {
            return true
        }
        
        val yBlock = Math.floor(row/3).toInt
        val xBlock = Math.floor(col/3).toInt
        
        if(board(row)(col) != '.'){
            if(col == 8){
                return solveSudokuRecursion(0, row+1, board)
            } else {
                return solveSudokuRecursion(col+1, row, board)
            }
        } else {
            for(i <- 1 to 9){
                if(validateSudoku(col, row, i)){
                    
                    
                    blockReference(s"${yBlock}-${xBlock}")(i-1) = true
                    colReference(col)(i-1) = true
                    rowReference(row)(i-1) = true
                    board(row)(col) = (i + '0').toChar
                    
                    if(col == 8 && solveSudokuRecursion(0, row + 1, board))
                        return true
                    else if(col != 8 && solveSudokuRecursion(col + 1, row, board))
                        return true
                       
                    blockReference(s"${yBlock}-${xBlock}")(i-1) = false
                    colReference(col)(i-1) = false
                    rowReference(row)(i-1) = false
                    board(row)(col) = '.'
                }
            } 
            
            return false
        }
        
        false
    }
    
    def solveSudoku(board: Array[Array[Char]]): Unit = {
        createInitialReferences(board)
        solveSudokuRecursion(0, 0, board)
        blockReference = Map()
        colReference = Array.ofDim[Boolean](9,9)
        rowReference = Array.ofDim[Boolean](9,9)
    }
}