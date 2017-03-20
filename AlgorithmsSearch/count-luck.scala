import java.io.PrintWriter
import scala.util.control.Breaks._
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

  val sc: MyScanner   = MyScanner()
  val t: Int          = sc.nextInt
  val pw: PrintWriter = new PrintWriter(System.out)

  def getCountOfWands(n: Int, m: Int, arr: Array[String], arrB: Array[Array[Boolean]], ix: Int, iy: Int): (Int, Int, Boolean) = {
    arrB(iy)(ix) = true
    if(arr(iy)(ix) == '*') {
      (0, 1, true)
    } else if(arr(iy)(ix) == 'X') {
      (0, 0, false)
    } else {
      val l: List[(Int, Int, Boolean)] =
        List(

          if(ix + 1 < m && !arrB(iy)(ix + 1))
            getCountOfWands(n, m, arr, arrB, ix + 1, iy)
          else 
            (0, 0, false),
  
          if(ix - 1 >= 0 && !arrB(iy)(ix - 1))
            getCountOfWands(n, m, arr, arrB, ix - 1, iy)
          else
            (0, 0, false),

          if(iy + 1 < n && !arrB(iy + 1)(ix))
            getCountOfWands(n, m, arr, arrB, ix, iy + 1)
          else
           (0, 0, false),

          if(iy - 1 >= 0 && !arrB(iy - 1)(ix))
            getCountOfWands(n, m, arr, arrB, ix, iy - 1)
          else
            (0, 0, false)

        )

      val wands: List[(Int, Int, Boolean)] = l.filter(_._3)
      if(!wands.isEmpty) {
        val wandsN: Int = l.foldLeft(0)((x, y) => x + y._1)
        val wandsB: Int = l.foldLeft(0)((x, y) => x + y._2)

        if(wandsB >= 2) {
          (1 + wandsN, 1, true)
        } else {
          (wandsN, 1, true)
        }
      } else {
        (0, 1, false)
      }

    }

  }

  for(i <- 0 until t){

    val n: Int                      = sc.nextInt
    val m: Int                      = sc.nextInt
    val arr: Array[String]          = new Array[String](n)
    val arrB: Array[Array[Boolean]] = Array.ofDim[Boolean](n, m)
    var ix: Int                     = 0
    var iy:Int                      = 0
    var b: Boolean                  = false

    for {
      y <- 0 until n
    } {
      arr(y) = sc.next
      if(!b){

        breakable {
          for(x <- 0 until m) {
            if( arr(y)(x) == 'M' ) {
              ix = x
              iy = y
              b = true
              break
            }
          }
        }
      }
    }

    val k: Int = sc.nextInt
    pw.println(
      if(getCountOfWands(n, m, arr, arrB, ix, iy)._1 == k)
        "Impressed"
      else
        "Oops!"
    )

  }

  pw.flush

}
