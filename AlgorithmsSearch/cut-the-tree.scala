import scala.collection.mutable.ListBuffer
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

case class Tree(value: Int, var totalValue: Int, var childs: Option[ListBuffer[Tree]] = None, var father: Option[Tree] = None) { self =>

  def addChild(t: Tree) = {
    childs match {
      case None =>
        self.childs = Some(ListBuffer(t))
      case Some(l) =>
        l.append(t)
    }
    t.father = Some(self)
    sumValue(t.value)
  }

  def sumValue(v: Int): Unit = {
    totalValue += v
    father match {
      case None    => ()
      case Some(f) => f.sumValue(v)
    }
  }

}

object Solution extends App {

  val sc: MyScanner = MyScanner()
  val n: Int = sc.nextInt
  val vertices: Array[Tree] = new Array[Tree](n)
  var minDifference: Int = Int.MaxValue
  val pw: PrintWriter = new PrintWriter(System.out)

  for(i <- 0 until n){
    val v: Int = sc.nextInt
    vertices(i) = Tree(v, v)
  }

  for(i <- 0 until n - 1){
    val f: Tree = vertices(sc.nextInt - 1)
    val s: Tree = vertices(sc.nextInt - 1)
    f.addChild(s)
  }

  def setMinimumDifference(t: Tree): Unit = t.childs match {

    case None         => ()
    case Some(childs) =>
      for(c <- childs) {
        val pm: Int = Math.abs(t.totalValue - c.totalValue - c.totalValue)
        if(pm < minDifference)
          minDifference = pm
        setMinimumDifference(c)
      }
      
  }

  setMinimumDifference(vertices(0))
  pw.flush

}
