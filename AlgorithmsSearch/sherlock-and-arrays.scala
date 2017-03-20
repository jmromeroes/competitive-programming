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
  import scala.util.control.Breaks._

  val sc: MyScanner = MyScanner()
  val T: Int = sc.nextInt
  val pw: PrintWriter = new PrintWriter(System.out)

  for (t <- 0 until T) {
    val n: Int = sc.nextInt
    val arr: Array[Int] = new Array[Int](n)
    var acc: Int = 0
    var acc2: Int = 0
    var b: Boolean = false

    for(i <- 0 until n) {
      arr(i) = sc.nextInt
      acc += arr(i)
    }

    breakable {
      for(i <- 0 until n){
        acc2 += arr(i)
        val k: Int = acc - acc2
        if(k + arr(i) == acc2) {
          b = true
          break
        }
      }
    }

    pw.println(if(b) "YES" else "NO")

  }

  pw.flush

}
