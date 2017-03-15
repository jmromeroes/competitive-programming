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
  import java.io.PrintWriter 

  val sc: MyScanner = MyScanner()
  val n: Int = sc.nextInt
  val m:Int = sc.nextInt
  val pw: PrintWriter = new PrintWriter(System.out)

  val arr: Array[Array[Int]] = Array.ofDim[Int](n, m)
  val arrB: Array[Array[Boolean]] = Array.ofDim[Boolean](n, m)

  for {
    y <- 0 until n
    x <- 0 until m
  } yield {
    arr(y)(x) = sc.nextInt
  }

  def returnSize(x: Int, y:Int):Int = {
    
      arrB(y)(x) = true

      if(arr(y)(x) == 1) {
        val r1: Int =
          if(y + 1 < n && !arrB(y + 1)(x))
            returnSize(x, y + 1)
          else
            0
   
        val r2: Int =
          if(x + 1 < m && !arrB(y)(x + 1))
            returnSize(x + 1, y)
          else
            0
   
        val r3: Int =
          if(y - 1 >= 0 && !arrB(y - 1)(x))
            returnSize(x, y - 1)
          else
            0
   
        val r4: Int =
          if(x - 1 >= 0 && !arrB(y)(x - 1))
            returnSize(x - 1, y)
          else
            0

        val r5: Int =
          if(y + 1 < n && x + 1 < m && !arrB(y + 1)(x + 1))
            returnSize(x + 1, y + 1)
          else
            0
   
        val r6: Int =
          if(x + 1 < m && y - 1 > 0 && !arrB(y - 1)(x + 1))
            returnSize(x + 1, y - 1)
          else
            0
   
        val r7: Int =
          if(y - 1 >= 0 && x - 1 >= 0 && !arrB(y - 1)(x - 1))
            returnSize(x - 1, y - 1)
          else
            0
   
        val r8: Int =
          if(x - 1 >= 0 && y + 1 < n && !arrB(y + 1)(x - 1))
            returnSize(x - 1, y + 1)
          else
            0

        r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8 + 1

      } else 0


  }

  var maxSize = 0

  val l = for{
    y <- 0 until n
    x <- 0 until m
    if(!arrB(y)(x))
  } yield {
    val r: Int = returnSize(x, y)
    maxSize =
      if(r > maxSize)
        r
      else maxSize

  }

  pw.print(maxSize)
  pw.flush

}
