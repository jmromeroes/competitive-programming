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
    
    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/      
      val sc = MyScanner()
      val n: String = sc.next
      val k: Int = sc.nextInt
        
      def superdigit(l: String): Int = l match {
        case s1 if s1.size == 1 =>
          l.toInt
        case s =>
          val r: Int = s.foldLeft(0)((x, y) => { x + (y - '0').toInt })  
          val r2: BigInt = if(s == n) BigInt(r.toString) * BigInt(k.toString) else BigInt(r.toString)
          
          superdigit(r2.toString)
      }
      
      println(superdigit(n))
    }

}
