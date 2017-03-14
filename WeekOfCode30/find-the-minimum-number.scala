object Solution extends App {
    import java.io.PrintWriter
        
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    val pw: PrintWriter = new PrintWriter(System.out)
    
    def buildResult(index: Int): String = {
      val sb: StringBuilder = new StringBuilder()
      index match {
        case _ if index < n =>
          sb.append("min(int, ")
            .append(buildResult(index + 1))
            .append(")").toString
        case _  => "int"                   
      }
    }                                           
    
    pw.print(buildResult(1))
    pw.flush
}
