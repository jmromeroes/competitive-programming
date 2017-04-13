object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
      import scala.collection.mutable.Map
        
      val m: Map[Char, Int] = Map()
      
      val s1: String = scala.io.StdIn.readLine
      val s2: String = scala.io.StdIn.readLine
      var res: Int   = 0
        
      for(c <- s1){
        m get c match {
          case None =>
            m(c) = 1
          case Some(ch) =>
            m(c) = ch + 1
        }
      }
      
      for(c <- s2){
        m get c match {
          case None =>
            res += 1
          case Some(ch) =>
            m(c) = ch - 1
        }
      }
      
      res += m.values.foldLeft(0)(Math.abs(_) + Math.abs(_))
      println(res)
    }
}
