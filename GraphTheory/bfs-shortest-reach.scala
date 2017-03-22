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
  val pw: PrintWriter = new PrintWriter(System.out)
  val q: Int = sc.nextInt
  
  for(i <- 0 until q){
    val n: Int = sc.nextInt
    val m: Int = sc.nextInt
    val adjacency: Array[List[Int]] = new Array[List[Int]](n)

    for(_ <- 0 until m){
      val u: Int = sc.nextInt - 1
      val v: Int = sc.nextInt - 1
      
      adjacency(u) =
        adjacency(u) match {
          case null =>
            List(v)
          case storedList =>
            v :: storedList
        }

      adjacency(v) =
        adjacency(v) match {
          case null =>
            List(u)
          case storedList =>
            u :: storedList
        }

    }

    val s: Int = sc.nextInt - 1

    val results: Array[Int] = new Array[Int](n)

    def assignDistances(node: Int = s, accumulatedValue: Int = 0): Unit = {
      if(adjacency(node) != null){
        for(n1 <- adjacency(node)){
          if(n1 != s) {
            results(n1) match {
              case 0 =>
                results(n1) = accumulatedValue + 6
                assignDistances(n1, results(n1))
              case i =>
                if(i > accumulatedValue + 6) {
                  results(n1) = accumulatedValue + 6
                  assignDistances(n1, results(n1))
                }
            }
          }
        }

      }
    }

    assignDistances()

    val sb: StringBuilder = new StringBuilder()
    for (r <- 0 until results.size){
      if(r != s)
        sb.append(if(results(r) == 0) "-1 " else s"${results(r)} ")
    }

    pw.println(sb.toString)

  }

  pw.flush
}
