object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        var n = sc.nextInt
        var squares = new Array[Int](n)
        for(squares_i <- 0 to n-1) {
           squares(squares_i) = sc.nextInt
        }
        val d: Int = sc.nextInt
        val m: Int = sc.nextInt
        var r: Int = 0
        
        for(i <- 0 to n - m){
          var sum: Int = 0
          for(j <- i until i + m){
            sum += squares(j)
          }
          if(sum == d)
            r += 1
        }
        
        println(r)        
    }
}
