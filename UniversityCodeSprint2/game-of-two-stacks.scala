val numberOfGames: Int = scala.io.StdIn.readInt()

def getBestScore(stackSizes: Array[Int], stack1: Array[BigInt], stack2: Array[BigInt]): BigInt = {

  val maxScore: Int = stackSizes(2)
  var currentScore: BigInt = 0

  var y: Int = stackSizes(1)

  while(y >= 0) {
    var x: Int = stackSizes(0)

    while(stack2(y) > maxScore)
      y -=1

    while(x >= 0 && (stack1(x) + stack2(y) > maxScore || stack1(x) > maxScore)) {
      x -= 1
    }

    if( x >= 0 && x + y > currentScore)
      currentScore = x + y

    y -= 1

  }

  currentScore

}

for(n <- 0 until numberOfGames){
  val stacksSizes: Array[Int] =
    scala.io.StdIn.readLine.split(" ").map(_.toInt)
  val stack1: Array[BigInt] =
    scala.io.StdIn.readLine.split(" ").scanLeft(BigInt("0"))((a,b) => a + BigInt(b))
  val stack2: Array[BigInt] =
    scala.io.StdIn.readLine.split(" ").scanLeft(BigInt("0"))((a,b) => a + BigInt(b))
  println(getBestScore(stacksSizes, stack1, stack2))

}

