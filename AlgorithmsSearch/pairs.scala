
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

object Solution extends App{
  import java.io.PrintWriter
  import scala.collection.mutable.HashSet

  val sc: MyScanner        = MyScanner()
  val n: Int               = sc.nextInt
  val k: BigInt            = BigInt(sc.next)
  val map: HashSet[BigInt] = HashSet()
  val arr: Array[BigInt]   = new Array[BigInt](n)
  var res: Int = 0
  val pw: PrintWriter = new PrintWriter(System.out)

  for(i <- 0 until n){
    arr(i) = BigInt(sc.next)
    map += arr(i)
  }
  
  for(i <- 0 until n) {

    val x: BigInt = arr(i) + k

    map contains x match {
      case false =>
        ()
      case true =>
        res += 1
    }
  }

  pw.print(res)
  pw.flush

}
