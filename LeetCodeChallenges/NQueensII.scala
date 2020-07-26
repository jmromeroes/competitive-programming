object Solution {
    case class Queen(col: Int, row: Int)
    
    def verifyQueen(col: Int, row: Int, queens: List[Queen]): Boolean = 
        !queens.exists(queen =>
            row == queen.row || 
            col == queen.col ||
            Math.abs(col - queen.col) == Math.abs(row - queen.row)
        )
    
    def totalNQueensRecursion(n: Int, row: Int, acc: List[Queen]): Int = {
        if(n == row) 1
        else {
            for {
                col <- 0 until n
                queen = Queen(col, row)
                if(verifyQueen(col, row, acc))
            } yield totalNQueensRecursion(n, row + 1, queen :: acc)
        }.sum
    }
    
    def totalNQueens(n: Int): Int =
        totalNQueensRecursion(n, 0, List())
}