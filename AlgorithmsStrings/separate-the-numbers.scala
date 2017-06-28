object Solution extends App {
  
  def checkSequence(prev: String, rest: String): Boolean = {
    if(rest == "") true
    else if(rest.size < prev.size) false
    else if(rest.take(prev.size).toLong - prev.toLong == 1) checkSequence(rest.take(prev.size), rest.drop(prev.size))
    else if(rest.size > prev.size && rest.take(prev.size + 1).toLong - prev.toLong == 1) checkSequence(rest.take(prev.size + 1), rest.drop(prev.size + 1))    
    else false    
  }
  
  def getIfSequence(s: String): Option[String] = {
    for(i <- 1 to s.size/2){
      if(s.take(i)(0) == '0') return None
      
      if(checkSequence(s.take(i), s.drop(i)))
        return Some(s.take(i))
    }
    
    None
  }
  
  val t: Int = scala.io.StdIn.readLine.toInt
  
  for(_ <- 0 until t){
    val res = getIfSequence(scala.io.StdIn.readLine)
  
    res match {
      case Some(v) =>
        println(s"YES $v")
      case None =>
        println("NO")
    }
  }
}
