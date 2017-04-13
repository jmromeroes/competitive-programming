object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        var g = sc.nextInt
        var a0: Int = 0
          
        while(a0 < g){
          var n = sc.nextInt
          var sequence = new Array[Int](n)     
          var res: Int = 0
          var previous: Vector[Int] = Vector(0)
            
          for(sequence_i <- 0 to n-1) {
            sequence(sequence_i) = sc.nextInt
          }
          
          // If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
          
          for(i <- 1 until n-1){
            if(sequence(previous(previous.length - 1)) == 0 && sequence(i + 1) == 0){
              res += 1
              if(previous.length - 2 >= 0 && sequence(i + 1) == 0 && sequence(previous(previous.length - 2)) == 0){
                res += 1
                previous = previous init
              }
            } else {
              previous = previous :+ i
            }   
          }
          
          a0 += 1
          
          if(res % 2 == 0){
            println("Bob")
          } else {
            println("Alice")
          }
        }
      
        
    }
}
