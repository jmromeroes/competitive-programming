case class Node(v: Int, next: Option[Node])

case class Stack(){
  import scala.collection.mutable.ListBuffer
    
  var root: Option[Node] = None
  var max: Int = 0
  def add(v: Int) = {
    val n: Node = Node(v, root)
    root = Some(n)
    if(v > max)
      max = v
  }
  
  def delete() = {
    root match {
      case Some(v) =>
        root = v.next
        max = getMax(root, Int.MinValue)
      case None => ()
    }
  }
  
  def getMax() = max
  def getMax(n: Option[Node], max: Int): Int = n match {
    case None =>
      max
    case Some(v) =>
      if(v.v > max)
        getMax(v.next, v.v)
      else
        getMax(v.next, max)
  } 
}
  
object Solution extends App{
  val sc = new java.util.Scanner(System.in)
  val n: Int = sc.nextInt
  val s: Stack = Stack()
    
  for(_ <- 0 until n){
    val q: Int = sc.nextInt
    
    q match {
      case 1 =>
        s.add(sc.nextInt)  
      case 2 =>
        s.delete
      case 3 =>
        println(s.getMax())
    }
  }
}
