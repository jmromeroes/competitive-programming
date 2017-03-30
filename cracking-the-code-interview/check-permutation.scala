object Solution extends App {
  
  import scala.collection.mutable.Map
  import scala.util.control.Breaks._

  while(true){
    val s1: String = scala.io.StdIn.readLine
    val s2: String = scala.io.StdIn.readLine
    val map: Map[Char, Int] = Map()
    var b: Boolean = true
   
    for(c <- s1){
      map get c match {
        case None =>
          map += c -> 1
        case Some(v) =>
          map(c) = v + 1 
      }
    }
   
    breakable {
      for(c <- s2){
        map get c match {
          case None =>
            b = false
            break
          case Some(v) =>
            map(c) = v - 1
        }
      }
    }

    println(
      if( b )
        if(map.values.filter(_ > 0).size > 0) "NO" else "YES"
      else
        "NO"
    )

  }
}
