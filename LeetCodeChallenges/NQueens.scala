object Solution {
    case class Queen(col: Int, row: Int)
    
    def verifyQueens(col: Int, row: Int, queens: List[Queen]): Boolean =
        !queens.exists(queen =>
            queen.col == col ||
            queen.row == row ||
            Math.abs((queen.col - col)) == Math.abs((queen.row - row))
        )
    
    def solveNQueensRecursion(n: Int, row: Int, acc: List[Queen]): List[List[Queen]] = {
        if(n == row){
            List(List())
        } else {
            for {
                col <- 0 until n
                queen = Queen(col, row)
                if(verifyQueens(col, row, acc))
                solution <- solveNQueensRecursion(n, row + 1, queen :: acc)
            } yield queen :: solution
        }.toList    
    }
    
    def mapQueenToString(n: Int, queen: Queen): String = { 
        for(i <- 0 until n) yield if(queen.col == i) 'Q' else '.'
    }.mkString
    
    def solveNQueens(n: Int): List[List[String]] = {
        solveNQueensRecursion(n, 0, List()).map(_.map(queen => mapQueenToString(n, queen)))
    }
    
}