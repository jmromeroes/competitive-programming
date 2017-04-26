object Solution extends App {
  val sc = new java.util.Scanner(System.in)
  val n: Int = sc.nextInt
  
  for(_ <- 0 until n) {
    val s: String = sc.next
    println({s.foldLeft((0, 0.toChar))((x, c) => if(c == x._2) (x._1 + 1, x._2) else (x._1, c))}._1)
  }
}
