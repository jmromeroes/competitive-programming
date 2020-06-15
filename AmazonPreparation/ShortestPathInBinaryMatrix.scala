import scala.collection.mutable._
import scala.util.control.Breaks._

object Solution {
    
    def addToQueue(x: Int, y: Int, grid: Array[Array[Int]], level: Int, queue: Queue[(Int, Int, Int)]){
        val n: Int = grid.length
        
        if(x >= n || x < 0 || y >= n || y < 0 || grid(y)(x) == 1 || grid(y)(x) == -1){
            return
        }
        
        queue += ((x,y,level))
        grid(y)(x) = -1
    }
    
    def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
        
        val n = grid.length - 1
        
        if(grid.length == 0 || grid(0)(0) == 1 || grid(n)(n) == 1){
            return -1
        }
        
        var y: Int = 0
        var x: Int = 0
        var level: Int = 0
        
        if(grid(y)(x) == 1){
            return -1
        }
        
        val queue: Queue[(Int, Int, Int)] = Queue((x, y, level))
        
        val ops: List[(Int, Int) => (Int, Int)] = List(
            (x: Int, y: Int) => (x-1, y-1),
            (x: Int, y: Int) => (x, y-1),
            (x: Int, y: Int) => (x, y+1),
            (x: Int, y: Int) => (x+1, y+1),
            (x: Int, y: Int) => (x-1, y+1),
            (x: Int, y: Int) => (x+1, y-1),
            (x: Int, y: Int) => (x+1, y),
            (x: Int, y: Int) => (x-1, y)
        )
        
        grid(0)(0) = -1
        
        while(!queue.isEmpty){
            val (currX, currY, currLevel) = queue.dequeue

            if(currY == n && currX == n){
                return currLevel + 1;
            }
            
            for(op <- ops){
                val (newX, newY) = op(currX, currY)
                addToQueue(newX, newY, grid, currLevel+1, queue)
            }
        }
        
        return -1
    }
}