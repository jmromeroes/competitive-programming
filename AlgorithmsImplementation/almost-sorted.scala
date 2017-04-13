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
  import scala.util.control.Breaks._

  val sc: MyScanner = MyScanner()
  val n: Int = sc.nextInt
  val arr: Array[Int] = new Array[Int](n)
  
  def reverseUntilDown(x: Int): (Array[Int], Int, Int) = {
    var f: Int = x

    while(f < n - 1 && arr(f + 1) < arr(f)) {
      f += 1
    }

    (arr.take(x) ++ arr.drop(x).take(f - x + 1).reverse ++ arr.drop(f + 1), x, f)
  }
  
  def lookForSwap(x: Int): (Array[Int], Int, Int) = {
    val arr2: Array[Int] = arr
    
    for(i <- x + 2 until n){
      if(arr2(i) < arr2(i - 1)){
        val aaux: Int = arr2(x)
        arr2(x)= arr(i)  
        arr2(i) = aaux
        return (arr2, x, i)
      }
    }

    val aaux: Int = arr(x)
    arr2(x)= arr(x + 1)  
    arr2(x + 1) = aaux
 
    (arr2, x, x + 1)
  }
 
  def checkIfSorted(arr: Array[Int]): Boolean = {
    for(i <- 1 until n){
      if(arr(i) < arr(i - 1))
        return false
    }
    true
  }

  for(i <- 0 until n){
    arr(i) = sc.nextInt
  }

  breakable {
    for(i <- 0 until n - 1){
      if(arr(i) > arr(i + 1)){
        if(i < n - 2 && arr(i + 1) > arr(i + 2)){
          val a = reverseUntilDown(i)
          checkIfSorted(a._1) match {
            case true =>
              println(s"yes\nreverse ${a._2 + 1} ${a._3 + 1}")
            case false =>
              println("no")
          }       
        } else {
          val a = lookForSwap(i)
          checkIfSorted(a._1) match {
            case true =>
              println(s"yes\nswap ${a._2 + 1} ${a._3 + 1}")
            case false =>
              println("no")
          }       
        }
        break
      }
    }
  }

}
