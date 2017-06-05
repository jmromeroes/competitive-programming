object Solution extends App {

  val sc = new java.util.Scanner (System.in)
  var n = scala.io.StdIn.readInt
  
  val a = scala.io.StdIn.readLine.trim.split(" ")
    
  val n1 = a.slice(0, n/2).foldLeft(0)(_.toInt + _.toInt)
  val n2 = a.slice(n/2, n).foldLeft(0)(_.toInt + _.toInt)
    
  println(if(n1 == n2) 0 else Math.abs(n1 - n2))
}
