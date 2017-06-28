object Solution extends App {
  import scala.collection.mutable.Map
  
  val t: Int = scala.io.StdIn.readLine.toInt
  
  def getMinToAnam(s: String): Int = {
    if(s.size % 2 != 0) -1
    else {
      val m: Map[Char, Int] = Map()
      var c: Int = 0
      
      for(i <- 0  until s.size/2){
        m get s(i) match {
          case None => 
            m(s(i)) = 1
          case Some(v) =>
            m(s(i)) = v + 1
        }  
      }
      
      for(i <- s.size/2  until s.size){
        m get s(i) match {
          case None => 
            c += 1
          case Some(v) =>
            if(v < 1){
              c += 1
            } else {
              m(s(i)) = v - 1
            }
        }
      }
      
      c
    }
  }
  
  for(_ <- 0 until t){
    val s: String = scala.io.StdIn.readLine
    println(getMinToAnam(s))
  }
}
