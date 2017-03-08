object Solution {

    def main(args: Array[String]) {
      val sc: java.util.Scanner = new java.util.Scanner(System.in)
      val n: Int = sc.nextInt
      val l: Array[Int] = new Array[Int](100)
        
      for(_ <- 0 until n){
        val i: Int = sc.nextInt
        l(i) = l(i) + 1
      }
      
      println(l.mkString(" "))
      
    }
}
