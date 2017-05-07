object Solution extends App {
  import scala.collection.mutable.{ Map, ListBuffer }
    
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val unsorted = new Array[String](n)
  val map: Map[Int, ListBuffer[String]] = Map()
          
  def checkIfBigger(s1: String, s2: String): Boolean = {
    val n: Int = s1.size
    for(i <- 0 until n){
      if(s1(i) < s2(i))
        return true
      else if(s1(i) > s2(i))
        return false
    }    
    false
  }
  
  for(unsorted_i <- 0 to n-1) {
    unsorted(unsorted_i) = sc.next
    val s: Int = unsorted(unsorted_i).size 
    map get s match {
      case None =>
        map(s) = ListBuffer(unsorted(unsorted_i))
      case Some(v) =>
        v.append(unsorted(unsorted_i))
    }       
  }
  
  val rr = map.keys.toList.sorted
  for(r <- rr){
    for(i <- map(r).sortWith(checkIfBigger)){
      println(i)
    }
  }
  
}
