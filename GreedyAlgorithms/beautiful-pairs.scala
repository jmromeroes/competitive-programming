object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/  
      import scala.collection.mutable.Map
        
      val sc = new java.util.Scanner(System.in)
      val n: Int = sc.nextInt
      val mapA: Map[Int, Int] = Map()
      val mapB: Map[Int, Int] = Map()
        
      for(_ <- 0 until n){
        val v: Int = sc.nextInt
        
        mapA get v match {
          case None =>
            mapA += v -> 1
          case Some(c) =>
            mapA(v) = c + 1
        }
      }
      
      var resu: Int = 0
      var restB: Int = 0
      
      for(_ <- 0 until n){
        val v: Int = sc.nextInt
        
        mapA get v match {
          case None =>
            restB += 1
          case Some(c) =>
            if(c == 0)
              restB += 1
            else {
              mapA(v) = c - 1
              resu += 1
            }
        }
      }

      println(
        if(restB > 0 && mapA.values.count(_ > 0) > 0) 
          resu + 1 
        else if(restB == 0)
          resu - 1
        else
          resu
      )
      
    }
}
