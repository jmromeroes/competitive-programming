object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
        val sc = new java.util.Scanner(System.in)
        val n: Int = sc.nextInt
        val k: Int = sc.nextInt
        
        val b: Int = {
          for{ 
            i <- 0 until n 
          } yield {
            if(i == k){
              sc.nextInt
              0
            } else sc.nextInt
          }
        }.toList
         .foldLeft(0)(_ + _) / 2
        
        val bc: Int = sc.nextInt
        
        if(bc == b)
          println("Bon Appetit")
        else
          println(bc - b)
            
    }
}
