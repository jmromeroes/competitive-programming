object Solution extends App {
  val sc = new java.util.Scanner (System.in)
  val n = sc.nextInt
  
  var min1a = (Int.MaxValue, Int.MaxValue)
  var min1b = (Int.MaxValue, Int.MaxValue)
  var min2a = (Int.MaxValue, Int.MaxValue)
  var min2b = (Int.MaxValue, Int.MaxValue)
      
  for(ar1_i <- 0 until n) {
    val a = sc.nextInt
    if(a < min1a._1){
      min1b = (min1a._1, 0)
      min1a = (a, ar1_i)
    } else if(a < min1b._1){
      min1b = (a, ar1_i)
    }
  }
  
  for(ar2_i <- 0 until n) {
    val a = sc.nextInt
    if(a <= min2a._1){
      min2b = (min2a._1, 0)
      min2a = (a, ar2_i)
    } else if(a <= min2b._1){
      min2b = (a, ar2_i)
    }  
  }
  
  if(min1a._2 != min2a._2){
    println(min1a._1 + min2a._1)
  } else {
    println(Math.min(min1a._1 + min2b._1, min1b._1 + min2a._1))
  }
  
}
