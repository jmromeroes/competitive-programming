//Didn't use any kind of Arrays
object Solution extends App{
  import scala.collection.mutable.Map
    
  val sc = new java.util.Scanner(System.in)
  val m: Map[String, Int] = Map()

  for(_ <- 0 until sc.nextInt){
    val s: String = sc.next
    m get s match {
      case None =>
        m += s -> 1
      case Some(v) =>
        m(s) = v + 1
    } 
  }
  
  for(_ <- 0 until sc.nextInt){
    println(
      m get sc.next match {
        case None =>
          "0"
        case Some(v) =>
          v
      }
    )  
  }
  
}
