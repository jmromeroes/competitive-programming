val sc = new java.util.Scanner(System.in)

val n: Int = sc.nextInt

def checkIfPInG(P: Array[Array[Char]], pDim: (Int, Int))(G: Array[Array[Char]], gDim: (Int, Int)): Boolean = {

  def verifyPattern(y: Int, x: Int): Boolean = {

    for{
      y1 <- 0 until (pDim._1)
      x1 <- 0 until (pDim._2)
    } {
      if(P(y1)(x1) != G(y1 + y)(x1 + x))
        return false
    }

    true

  }

  var isVerifying: Boolean = false

  for {
    y <- 0 until (gDim._1 - pDim._1 + 1)
    x <- 0 until (gDim._2 - pDim._2 + 1)
  } {
    if(G(y)(x) == P(0)(0) && !isVerifying) {
      isVerifying = true
      if(verifyPattern(y, x))
        return true
    }
    isVerifying = false
  }

  false

}

for( i <- 0 until n ) {

  val gDim: (Int, Int) = (sc.nextInt, sc.nextInt)
  val G: Array[Array[Char]] = Array.ofDim[Char](gDim._1, gDim._2)

  sc.nextLine
  for {
    y <- 0 until gDim._1
  } {
    G(y) = sc.nextLine.toArray
  }

  val pDim: (Int, Int) = (sc.nextInt, sc.nextInt)
  val P: Array[Array[Char]] = Array.ofDim[Char](gDim._1, gDim._2)

  sc.nextLine
  for {
    y <- 0 until pDim._1
  } {
    P(y) = sc.nextLine.toArray
  }

  val r: String =
    if(checkIfPInG(P, pDim)(G, gDim))
      "YES"
    else
      "NO"

  println(r)

}
