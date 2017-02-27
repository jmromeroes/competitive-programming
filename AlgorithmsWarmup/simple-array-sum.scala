val n: Int = scala.io.StdIn.readInt()
val l: Array[Int] = scala.io.StdIn.readLine.split(" ").map(_.toInt)
println(l.reduce(_ + _))
