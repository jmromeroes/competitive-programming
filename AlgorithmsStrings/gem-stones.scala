object Solution {
    import scala.collection.mutable.Map

    def main(args: Array[String]) {    
      val sc = new java.util.Scanner(System.in)
      val n: Int = sc.nextInt
      val m: Map[Char, Int] = Map()
      for(_ <- 0 until n){
        val s: String = sc.next.distinct
        for(c <- s){
          m get c match {
            case None =>
              m += c -> 1
            case Some(v) =>
              m(c) = v + 1
          }
        }
      }
      
      println(m.values.count(x => x == n))
    }
}
