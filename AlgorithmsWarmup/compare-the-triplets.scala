val alice: Array[Int] = scala.io.StdIn.readLine().split(" ").map(_.toInt)
val bob: Array[Int] = scala.io.StdIn.readLine().split(" ").map(_.toInt)
var aliceScore: Int = 0
var bobScore: Int = 0
for {
  i <- 0 until 3
} {
  if(alice(i) < bob(i))
    bobScore += 1
  else if(alice(i) > bob(i))
    aliceScore += 1
}

println(s"$aliceScore $bobScore")
