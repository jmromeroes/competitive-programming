object Solution {

    def main(args: Array[String]) {
        import scala.util.control.Breaks._
          
        val sc = new java.util.Scanner (System.in)
        var q: Int = sc.nextInt
        var a0: Int = 0
        
        def swap(arr: Array[Int], x1: Int, x2: Int) = {
          val aux: Int = arr(x1)
          arr(x1) = arr(x2)
          arr(x2) = aux
        }
      
        while(a0 < q){
          var n = sc.nextInt
          var a = new Array[Int](n)
            
          for(a_i <- 0 until n) {
            a(a_i) = sc.nextInt  
            //Start sorting it
            if(a_i != 0 && a(a_i) < a(a_i - 1) && Math.abs(a(a_i) - a(a_i - 1)) == 1)
              swap(a, a_i, a_i - 1)
          }
          
          var b2: Boolean = false
          var f: Boolean = false
            
          breakable {
            for(a_i <- 1 until n){
              var sorted: Boolean = true
                
              for(a_j <- 1 until n){
                if(a(a_j) < a(a_j - 1)){
                  sorted = false
                  if(Math.abs(a(a_j) - a(a_j - 1)) == 1){
                    swap(a, a_j, a_j - 1)
                  } else {
                    sorted = false
                    f = true
                    break
                  }
                }
              }
              
              if(sorted){
                b2 = true
                break
              } else if((!sorted && f)){
                b2 = false
                break
              }
            }
          }
          
          if(b2 || n == 1)
            println("Yes")
          else
            println("No")
          // Write Your Code Here
          a0 += 1
        }
    }
}
