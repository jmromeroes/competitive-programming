import java.io.{BufferedReader, IOException, InputStreamReader}
case class MyScanner() {
  import java.util.StringTokenizer

  var st: StringTokenizer = null
  val br: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
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
  import java.util.StringTokenizer
  import java.io._

  var sc: MyScanner = MyScanner()
  val n: Int = sc.nextInt
  val queries: Int = sc.nextInt
  val arr: Array[Int] = new Array[Int](n)
  val arrB: Array[Boolean] = new Array[Boolean](n)
  val pw: PrintWriter = new PrintWriter(System.out)

  for(i <- 0 until n){
    arr(i) = sc.nextInt
  }

  for(q <- 0 until queries){
    var res: Int = 0
    val left: Int  = sc.nextInt
    val right: Int = sc.nextInt
    val x:Int      = sc.nextInt
    val y: Int     = sc.nextInt
    
    for(i <- left to right) {
      if(arr(i) % x == y)
          res += 1
    }

    pw.println(res)
    pw.flush

  }
  
}
