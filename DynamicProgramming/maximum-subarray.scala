import java.io.PrintWriter
case class MyScanner() {
  import java.util.StringTokenizer
  import java.io.{BufferedReader, IOException, InputStreamReader}

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
  val pw: PrintWriter = new PrintWriter(System.out)

  def getMaximumValuesUncontiguous(arr: Array[Int], i: Int, sum: Int): Int = {
    val n: Int = arr.size
    if( i  == n - 1 ){
      val r1: Int = Math.max(arr(i) + sum, Math.max(sum, arr(i)))
      r1
    } else {
      val r1: Int = Math.max(arr(i) + sum, Math.max(sum, arr(i)))
      getMaximumValuesUncontiguous(arr, i + 1, r1)
    }
  }

  def getMaximumValuesContiguous(arr: Array[Int], i: Int): Int = {
    val n: Int = arr.size

    if( i  == n - 1 ){
      Math.max(Math.max(arr(i) + sum, sum), arr(i))
    } else {
      val r: Int = Math.max(sum, getMaximumValuesContiguous(arr, i + 1, arr(i)))
      Math.max(r, getMaximumValuesContiguous(arr, i + 1, arr(i) + sum))
    }
  }

  for(_ <- 0 until t){
    val n: Int = sc.nextInt
    val arr: Array[Int] = new Array[Int](n)

    for(i <- 0 until n){
      arr(i) = sc.nextInt
    }

    if(n == 1){
      pw.println(s"${arr(0)} ${arr(0)}")
    } else {
      val res: (Int, Int) = (getMaximumValuesContiguous(arr, 1, arr(0)),getMaximumValuesUncontiguous(arr, 1, arr(0)))
      pw.println(s"${res._1} ${res._2}")
    }

  }

  pw.flush

}
