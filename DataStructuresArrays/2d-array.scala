object Solution extends App{
  val sc = new java.util.Scanner (System.in)
  var arr = Array.ofDim[Int](6,6)
  var max: Int = Int.MinValue
    
  for(i <- 0 until 6) {
    arr(i) = scala.io.StdIn.readLine.split(" ").map(_.toInt)
  }
  
  for(i <- 0 until 4){
    for(j <- 0 until 4){
      var r: Int = 0
      r += arr(i)(j)
      r += arr(i)(j + 1)
      r += arr(i)(j + 2)
      r += arr(i + 1)(j + 1)
      r += arr(i + 2)(j)
      r += arr(i + 2)(j + 1)
      r += arr(i + 2)(j + 2)
        
      if(max < r)
        max = r
    }
  }
  
  println(max)
}
