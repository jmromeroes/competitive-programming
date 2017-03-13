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


object Solution {
  import scala.collection.mutable.{ Map, ListBuffer }  
  
  def main(args: Array[String]) {
    val sc: MyScanner = MyScanner()
    val ts: Int = sc.nextInt
    val pw: PrintWriter = new PrintWriter(System.out)
     
    for(_ <- 0 until ts) {
      val m: Int = sc.nextInt
      val n: Int = sc.nextInt
      val map: Map[Int, ListBuffer[Int]] = Map()
      val arr: Array[Int] = new Array[Int](n)
     
      for(i <- 0 until n){
        val v: Int = sc.nextInt
        arr(i) = v
     
        map get v match {
          case None =>
            map += v -> ListBuffer(i)
          case Some(m1) =>
            m1.append(i)
        }
      }
     
   
      def getResIndex(): (Int, Int) = {

        for(i <- 0 until n) {
          val x: Int = m - arr(i)

          map get x match {
            case None =>
              ()
            case Some(l) =>
              if(m - arr(i) == arr(i) && l.size > 1){
                return (i + 1,l(1) + 1)
              } else if(m - arr(i) != arr(i)){
                return (i + 1,l(0) + 1)
              }
          }
        }

        (0,0)

      }

      val res: (Int, Int) = getResIndex
      pw.format("%d %d", new Integer(res._1), new Integer(res._2))
      pw.println
      pw.flush

    } 

  }

}
