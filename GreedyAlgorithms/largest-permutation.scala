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
    import java.io.PrintWriter
      
    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/    
      import scala.util.control.Breaks._
      import scala.collection.mutable.Map
        
      val pw: PrintWriter = new PrintWriter(System.out)
      val sc: MyScanner = MyScanner()
      val n: Int = sc.nextInt
      val k: Int = sc.nextInt
      val arr: Array[Int] = new Array[Int](n)
      var iref: Int = 0
      val map: Map[Int, Int] = Map()
        
      def swap(x1: Int, x2: Int): Unit = {
        val aux: Int = arr(x1)
        map(arr(x1)) = x2
        map(arr(x2)) = x1
        arr(x1) = arr(x2)
        arr(x2) = aux
      }
      
      for(i <- 0 until n){
        arr(i) = sc.nextInt
        map += (arr(i) -> i)
      }
      
      if(k > n){  
        pw.println(arr.sortBy(-_).mkString(" "))
      } else {
        var j: Int = k
        breakable {
          while(j > 0){
            if(iref == n){
              break
            }else {
              val m: Int = map.get(n - iref).get
              if(m != iref){
                j -= 1
              }
              swap(m, iref)
              iref += 1
            }
          }  
        }
      
        pw.println(arr.mkString(" "))
          
      }
      
      pw.flush
    }
}
