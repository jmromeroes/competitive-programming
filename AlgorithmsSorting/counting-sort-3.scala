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

object Solution {
    import java.io.PrintWriter
    import scala.collection.mutable.ListBuffer

    def main(args: Array[String]) {
      val sc: MyScanner   = MyScanner()
      val pw: PrintWriter = new PrintWriter(System.out)
      val n: Int          = sc.nextInt
      val l: Array[Int]   = new Array[Int](100)
      val ls: Array[String] = new Array[String](100) 
        
      for(x <- 0 until n){
        val i: Int = sc.nextInt
        val s: String = sc.next
        if(x < n/2) { "-"
          ls(i) = "- "          
        } else {

        }
        if(ls(i) == null)
          ls(i) = v + " "
        else
          ls(i) = ls(i) + v + " "

      }
      
      for{
        y <- 0 until 100
        if(ls(y) != null)
      } {
        pw.print(ls(y))
      }

      pw.flush
    }

}
