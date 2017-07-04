object Solution extends App {
  import scala.collection.mutable.HashSet
  
  val t: Int = scala.io.StdIn.readLine.toInt
  
  def checkIfCommonSubstring(s1: String, s2: String): Boolean = {
    val m: HashSet[Char] = HashSet[Char]()
    
    for(c <- s1){
      m += c
    }
  
    for(c <- s2){
      if(m contains c)
        return true      
    }
    
    false
  }
  
  for(i <- 0 until t){
    println(
      if(checkIfCommonSubstring(scala.io.StdIn.readLine, scala.io.StdIn.readLine))
        "YES"
      else 
        "NO"
    )    
  }
  
}
