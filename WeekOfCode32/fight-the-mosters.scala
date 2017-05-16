object Solution extends App {
  import scala.util.control.Breaks._
   
  val sc = new java.util.Scanner (System.in)
  var n: Int = sc.nextInt
  var hit: Int = sc.nextInt
  var t: Int = sc.nextInt
  var r: Int = 0
  var h = new Array[Int](n)
  for(h_i <- 0 to n-1) {
     h(h_i) = sc.nextInt
  }
  
  breakable {
    for(i <- h.sorted){
      val r2 = i / hit.toFloat
      if(i - hit <= 0){
        t -= 1
      } else if(i % hit != 0){
        t -= (r2.toInt + 1)
      } else {
        t -= r2.toInt
      }
      if(t >= 0){
        r += 1
      } else 
        break
    }
  }
  
  println(r)
}
