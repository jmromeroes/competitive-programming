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
  import scala.collection.mutable.HashSet

  val sc: MyScanner = MyScanner()
  val s: String = sc.next
  val n: Int = sc.nextInt
  val q: Array[Int] = new Array[Int](n)
  val m: HashSet[BigInt] = HashSet()

  def addWeightsToSet(s: String): Unit = s.isEmpty match {
    case true  => ()
    case false =>
      m += (s(0).asInstanceOf[Int] - 96) * s.size
      addWeightsToSet(s.take(s.size - 1))      
  }

  def analyse(s: String, n: Int): Unit = s.isEmpty match {
        
    case true =>
      ()
    case false =>
      if(s.size == 1) {
        addWeightsToSet(s.take(1))
      } else if(n >= s.size || s(n) != s(n - 1)){
        addWeightsToSet(s.take(n))
        analyse(s.drop(n), 1)
      } else {
        analyse(s, n + 1)
      }
  }
    
  analyse(s, 1)

  for (i <-  0 until n){
    m contains sc.nextInt match {
      case true =>
        println("Yes")
      case false =>
        println("No")
    }    
  }

}

e
