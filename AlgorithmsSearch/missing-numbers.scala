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
    val pw: PrintWriter = new PrintWriter(System.out)

    val n: Int = sc.nextInt
    val mapN: Map[Int, Int] = Map()
   
    for(i <- 0 until n){
      val v: Int = sc.nextInt
   
      mapN get v match {
        case None =>
          mapN += v -> 1
        case Some(m1) =>
          mapN(v) = m1 + 1
      }
    }
   
    val m: Int = sc.nextInt
    val mapM: Map[Int, Int] = Map()
    val arrM: Array[Int] = new Array[Int](m)
   
    for(i <- 0 until m){
      val v: Int = sc.nextInt

      mapM get v match {
        case None =>
          mapM += v -> 1
        case Some(m1) =>
          mapM(v) = m1 + 1
      }
    }

    val res: ListBuffer[Int] = ListBuffer()
    for(a <- mapM.keys) {
      mapN get a match {
        case None =>
          res.append(a)
        case Some(v) =>
          if(mapM.get(a).get > v)
            res.append(a)
      }
    }

    pw.print(res.sorted.mkString(" "))
    pw.println
    pw.flush

  } 

}


