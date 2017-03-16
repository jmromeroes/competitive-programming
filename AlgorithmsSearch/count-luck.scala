import java.io.PrintWriter

case class MyScanner() {
  import java.util.StringTokenizer
  import java.io.{BufferedReader, IOException, InputStreamReader}
  import scala.util.control.Breaks._

  val br: BufferedReader  = new BufferedReader(new InputStreamReader(System.in))
  var st: StringTokenizer = null

  def next(): String = {

    while(st == null || !st.hasMoreElements) {
      try {
        st = new StringTokenizer(br.readLine)
      } catch {
        case e: IOException => e.printStackTrace
      }
    }

    st.nextToken

  }

  def nextInt(): Int       = next.toInt
  def nextFloat(): Float   = next.toFloat
  def nextChar(): Char     = next()(0)
  def nextDouble(): Double = next.toDouble
  def nextLong(): Long     = next.toLong

  def nextLine(): String = {

    var str: String = ""

    try {
      str = br.readLine
    } catch {
      case e: IOException =>
        e.printStackTrace
    }

    str
  }

}

object Solution extends App {

  val sc: MyScanner = MyScanner()
  val t: Int = sc.nextInt

  def getCountOfWands(n: Int, m: Int, arr: Array[Array[Char]], arrB: Array[Array[Bool]], ix: Int, iy: Int): Int = {

    arrB(iy)(ix) = true

    if(arr(iy)(ix) == '*')
      0
    else {
              
    }

  }

  for(i <- 0 until t){

    val n: Int = sc.nextInt
    val m: Int = sc.nextInt
    val arr: Array[Array[Char]] = Array.ofDim[Char](n, m)
    val arrB: Array[Array[Boolean]] = Array.ofDim[Boolean](n, m)
    var ix: Int = 0
    var iy:Int = 0

    for {
      y <- 0 until n
      x <- 0 until m
    } {
      arr(y)(x) = sc.nextChar
    }

    val k: Int = sc.nextInt
  }

}
