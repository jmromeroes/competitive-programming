val str: String  = scala.io.StdIn.readLine
val len: Int     = str.size
val lenSqrt: Int = Math.rint(Math.sqrt(len)).toInt
val dimension: (Int, Int) =
  if(Math.pow(lenSqrt, 2) >= len)
    (lenSqrt, lenSqrt)
  else
    (lenSqrt + 1, lenSqrt)
val array: Array[Array[Char]] = Array.ofDim[Char](dimension._2, dimension._1)
var i: Int = 0

for {
  y <- 0 until dimension._2
  x <- 0 until dimension._1
} {

  val i: Int = (y * dimension._1) + x
  if(i < str.size)
    array(y)(x) = str(i)

}

for (x <- 0 until dimension._1) {
  for (y <- 0 until dimension._2) {
    if(array(y)(x) != 0.toChar)
      print(array(y)(x)) 
  }
  if(x != dimension._1 - 1)
    print(" ")
}
