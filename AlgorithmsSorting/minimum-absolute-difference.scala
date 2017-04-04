object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        var n = sc.nextInt
        var a = new Array[Int](n)
        for(a_i <- 0 to n-1) {
           a(a_i) = sc.nextInt
        }
        
        val a2: Array[Int] = a.sorted
        var min: Int = Int.MaxValue
        for(i <- 1 until a2.size){
          val diff: Int = Math.abs(a2(i) - a2(i - 1))
          if(diff < min)
            min = diff
        }
        
        println(min)
    }
}
