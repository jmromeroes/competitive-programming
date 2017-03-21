import java.io.PrintWriter
import scala.util.control.Breaks._
import scala.collection.mutable.ListBuffer

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

case class Tree(val index: Int, var children: Option[ListBuffer[Tree]] = None, var father: Option[Tree] = None, var weight: Int = 1) { self =>

  def addChild(child: Tree) {
    children match {
      case None =>
        children = Some(ListBuffer(child))
      case Some(l) =>
        l.append(child)
    }
    
    child.father = Some(self)
    addWeight
  }

  def addWeight(): Unit = {
    self.weight += 1
    father match {
      case None =>
        ()
      case Some(f) =>
        f.addWeight
    }
  }

}

object Solution extends App {

  val sc: MyScanner = MyScanner()
  val n: Int = sc.nextInt
  val m: Int = sc.nextInt
  val vertices: Array[Option[Tree]] = new Array[Option[Tree]](n)
  val pw: PrintWriter = new PrintWriter(System.out)

  for(i <- 0 until m){
    val indexC: Int = sc.nextInt - 1
    val indexF: Int = sc.nextInt - 1

    val child: Tree = vertices(indexC) match {
      case Some(c) =>
        c
      case _ =>
        vertices(indexC) = Some(Tree(indexC))
        vertices(indexC).get 
    }

    val father: Tree = vertices(indexF) match {
      case Some(f) =>
        f
      case _ =>
        vertices(indexF) = Some(Tree(indexF))
        vertices(indexF).get
    }

    father.addChild(child)
  }

  def calculateNumberOfEven(t: Tree): Int = t.children match {
    case None =>
      0
    case Some(children) =>
      var ec: Int = 0

      for(c <- children){
        if(c.weight % 2 == 0) {
          ec += 1
        }
        ec += calculateNumberOfEven(c)
      }
      ec
  }

  pw.println(calculateNumberOfEven(vertices(0).get))
  pw.flush

}
