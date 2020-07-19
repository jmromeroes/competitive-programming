import scala.collection.mutable._

object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        val blockRef: Map[String, Array[Boolean]] = Map()
        val colRef = Array.ofDim[Boolean](9, 9)
        val rowRef = Array.ofDim[Boolean](9, 9)
        
        for {
            blockY <- 0 until 3
            blockX <- 0 until 3
            y <- 0 until 3
            x <- 0 until 3
        } yield {
            val row = blockY*3 + y
            val col = blockX*3 + x
            
            if(board(row)(col) != '.'){
                val keyValue = board(row)(col) - '0' - 1

                val blockKey: String = s"$blockX-$blockY"
                blockRef.get(blockKey) match {
                    case None => 
                        val newArray = new Array[Boolean](9)
                        newArray(keyValue) = true    
                        blockRef(blockKey) = newArray
                    case Some(array) =>
                        if(array(keyValue))
                            return false
                        else
                            array(keyValue) = true
                }

                if(colRef(col)(keyValue))
                    return false
                else
                    colRef(col)(keyValue) = true

                if(rowRef(row)(keyValue))
                    return false
                else
                    rowRef(row)(keyValue) = true

            }
            
        }       
        
        true
    }
}