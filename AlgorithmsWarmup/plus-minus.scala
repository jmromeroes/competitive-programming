val n: Int = scala.io.StdIn.readInt
val l: Array[Int] = scala.io.StdIn.readLine.split(" ").map(_.toInt)
val positiveFraction: Double = l.filter(_ > 0).size.toDouble / n
val negativeFraction: Double = l.filter(_ < 0).size.toDouble / n
val zeroesFraction: Double = 1 - positiveFraction - negativeFraction
println(positiveFraction)
println(negativeFraction)
println(zeroesFraction)
