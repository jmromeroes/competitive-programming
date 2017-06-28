object Solution extends App {
  val t: Int = scala.io.StdIn.readLine.toInt
  
  def checkIfPalindrome(s: String): Boolean = {
    for(i <- 0 until s.size/2){
      if(s(i) != s(s.size - 1 - i))
        return false
    }   
    true
  }
    
  def checkIndexToRemove(s: String): Int = {
    var b: Int = 0
    var e: Int = s.size - 1
    
    while(b < e){
      if(s(b) != s(e)){
        if(checkIfPalindrome(s.take(b) + s.drop(b + 1)))
          return b
        else if(checkIfPalindrome(s.take(e) + s.drop(e + 1)))
          return e      
      }
      
      b += 1
      e -= 1
    }
    
    -1
  }
  
  for(_ <- 0 until t){
    val s: String = scala.io.StdIn.readLine
    println(checkIndexToRemove(s))
  }
  
}
