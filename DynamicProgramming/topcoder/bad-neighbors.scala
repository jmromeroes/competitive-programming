object Solution extends App {
  val as: Array[Int] = scala.io.StdIn.readLine.split(" ").map(_.toInt).toArray
  val n: Int = as.size
  var count1: Int = 0
  var count2: Int = 0

  for(i <- 1 to n + 1 by 2){
    if(i < n){
      count1 += as(i)
    }

    if(i - 1 < n){
      count2 += as(i - 1)
    }
  }

  println(Math.max(count1, count2))
}
