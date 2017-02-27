val h: Int = scala.io.StdIn.readInt
val array: Array[Array[Int]] =       
  {
    for {
      y <- 0 until h
    } yield {
      scala.io.StdIn.readLine().split(" ").map(_.toInt)  
    }
  }.toArray

var firstSum = 
  {
    for {
      y <- 0 until h
    } yield {
      array(y)(y)       
    }
  }.reduce(_ + _)

var secondSum = 
  {
    for {
      y <- 0 until h
    } yield {
      array(h - 1 - y)(y)       
    }
  }.reduce(_ + _)

println(Math.abs(firstSum - secondSum))
