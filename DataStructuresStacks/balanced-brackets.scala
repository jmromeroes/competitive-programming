object Solution extends App{
  import scala.collection.mutable.Stack
  
  val sc = new java.util.Scanner (System.in)
  val t = sc.nextInt
  var a0: Int = 0
    
  def analyzeBalance(s: String): Boolean = {
    val l: Stack[Char] = Stack()
      
    for(c <- s){
      c match {
        case ')' =>
          if(l.size == 0)
            return false
          
          l.pop match {
            case '(' => ()
            case _   => return false
          }
        
        case ']' =>          
          if(l.size == 0)
            return false
          
          l.pop match {
            case '[' => ()
            case _   => return false
          }
        
        case '}' =>
          if(l.size == 0)
            return false
          
          l.pop match {
            case '{' => ()
            case _   => return false
          }
        
        case _ =>
          l.push(c)
          
      } 
    }
    
    if(l.size == 0)
      true
    else 
      false
  }

  while(a0 < t){
    var s = sc.next
    val res: Boolean = analyzeBalance(s)
    
    println(if(res) "YES" else "NO")
    a0+=1
  }
}
