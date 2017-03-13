class MyScanner {

  val br: BufferedReader = new BufferedReader(new InputStreamReader(System.in))
  var st: StringTokenizer = null
  
  def next(): String = {

    while(st == null || !st.hasMoreElements) {
       try {
          st = new StringTokenizer(br.readLine)
       } catch (IOException e) {
          e.printStackTrace
       }
    }
    
    st.nextToken

  }

  def nextInt: Int       = next.toInt
  def nextChar: Char     = next.toChar
  def nextDouble: Double = next.toDouble
  def nextFloat: Float   = next.toFloat
  def nextLong: Long     = next.toLong

  def nextLine: String = {

    var str: String = ""

    try {
       str = br.readLine
    } catch (IOException e) {
       e.printStackTrace
    }

    return str

  }

}

