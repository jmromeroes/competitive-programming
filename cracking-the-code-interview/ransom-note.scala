object Solution {

  def main(args: Array[String]) {
    import scala.collection.mutable.Map
            
    val sc = new java.util.Scanner (System.in)
    val m = sc.nextInt()
    val n = sc.nextInt()
    val map: Map[String, Int] = Map()
       
    for(magazine_i <- 0 to m-1) {
       val s: String = sc.next()
       map get s match {
         case None =>
           map += s -> 1
         case Some(v) =>
           map(s) = v + 1           
       }
    }
    var b: Boolean = true

    for(ransom_i <- 0 to n-1) {
      val s: String = sc.next()
      map get s match {
        case None =>
          b = false
        case Some(q) =>
          if(q <= 0) b = false
          map(s) = q - 1
      }
    }
    
    println(if(b) "Yes" else "No")
  }
}
