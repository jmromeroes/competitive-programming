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
  import scala.collection.mutable.{Map, ListBuffer}

  def quicksort(l: List[Int]): List[Int] = l match {
    case Nil =>
      List()
    case x :: Nil =>
      List(x)
    case x :: xs =>
      val left: List[Int] = xs.filter(_ < x)
      val right: List[Int] = xs.filter(_ > x)

      quicksort(left) ::: List(x) ::: quicksort(right) 
  }

  val sc: MyScanner = MyScanner()
  val n: Int = sc.nextInt
  val arr: Array[Int] = new Array[Int](n)

  for(i <- 0 until n) {
    arr(i) = sc.nextInt
  }

  val sortedList: List[Int] = quicksort(arr.toList)
  val m: Map[Int, ListBuffer[Int]] = Map()
  var minDiff: Int = Int.MaxValue

  for(i <- 1 until n) {
    val d: Int = sortedList(i) - sortedList(i - 1)
    if(minDiff > d)
      minDiff = d

    m get d match {
      case None    =>
        m += d -> ListBuffer(sortedList(i - 1), sortedList(i))
      case Some(v) =>
        v.append(sortedList(i - 1))
        v.append(sortedList(i))
    }
  }

  m get minDiff match {
    case None => ()
    case Some(v) =>
      v.foreach(x => print(x + " "))
  }

}
