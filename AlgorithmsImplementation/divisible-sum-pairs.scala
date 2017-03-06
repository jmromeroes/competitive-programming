object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        val n: Int = sc.nextInt()
        val k: Int = sc.nextInt()
        val a: Array[Int] = new Array[Int](n)
        var nd: Int = 0
            
        for(a_i <- 0 to n-1) {
           a(a_i) = sc.nextInt()
        }
        
        for(y <- 0 to n - 2) {
          for(x <- y + 1 to n - 1){
            if((a(y) + a(x)) % k == 0)
              nd += 1
          }              
        }
        
        print(nd)
    }
}
