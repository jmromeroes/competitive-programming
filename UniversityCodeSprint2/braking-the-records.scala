object BreakingTheRecords extends App {

  val n: Int = scala.io
                    .StdIn
                    .readInt()
   
  val l: Array[Int] = scala.io
                          .StdIn
                          .readLine()
                          .split(" ")
                          .map(_.toInt)
   
  var maxValue: Int = l(0)
  var minValue: Int = l(0)
   
  val maxTimes: Int = l.foldLeft(0)((a, b) => {
      if(b > maxValue) {
        maxValue = b
        a + 1
      } else a
    })
   
  val minTimes: Int = l.foldLeft(0)((a, b) => {
      if(b < minValue) {
        minValue = b
        a + 1
      } else a
    })
   
  println(s"$maxTimes $minTimes")

}
