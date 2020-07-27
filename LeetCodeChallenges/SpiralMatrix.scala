object Solution {
    trait Direction
    object UP extends Direction
    object DOWN extends Direction
    object RIGHT extends Direction
    object LEFT extends Direction
    
    def spiralOrderRecursion(dir: Direction, size: (Int, Int), col: Int, row: Int, level: Int, matrix: Array[Array[Int]], set: Set[String]): List[Int] = {
        if(set.contains(s"${row}-${col}")) Nil
        else {
            dir match {
                case UP =>
                    if(row == level + 1) {
                        matrix(row)(col) :: spiralOrderRecursion(RIGHT, size, col + 1, row, level + 1, matrix, set + s"${row}-${col}")
                    } else if(row >= 0){
                        matrix(row)(col) :: spiralOrderRecursion(UP, size, col, row - 1, level, matrix, set + s"${row}-${col}")
                    } else Nil
                case DOWN =>
                    if(row == size._2 - level) {
                        matrix(row)(col) :: spiralOrderRecursion(LEFT, size, col - 1, row, level, matrix, set + s"${row}-${col}")
                    } else if(row <= size._2){
                        matrix(row)(col) :: spiralOrderRecursion(DOWN, size, col, row + 1, level, matrix, set + s"${row}-${col}")
                    } else Nil
                case RIGHT =>
                    if(col == size._1 - level) {
                        matrix(row)(col) :: spiralOrderRecursion(DOWN, size, col, row + 1, level, matrix, set + s"${row}-${col}")
                    } else if(col <= size._1){
                        matrix(row)(col) :: spiralOrderRecursion(RIGHT, size, col + 1, row, level, matrix, set + s"${row}-${col}")
                    } else Nil
                case LEFT => 
                    if(col == level) {
                        matrix(row)(col) :: spiralOrderRecursion(UP, size, col, row - 1, level, matrix, set + s"${row}-${col}")
                    } else if(col > 0){
                        matrix(row)(col) :: spiralOrderRecursion(LEFT, size, col - 1, row, level, matrix, set + s"${row}-${col}")
                    } else Nil
            }
        }
    }
    
    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
        if(matrix.isEmpty || matrix(0).isEmpty) return List()
        val size: (Int, Int) = (matrix(0).length - 1, matrix.length - 1)
        spiralOrderRecursion(RIGHT, size, 0, 0, 0, matrix, Set())
    }
}