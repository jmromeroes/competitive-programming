object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
      import scala.collection.mutable.ListBuffer
        
      val minVal: Int = scala.io.StdIn.readInt
      val maxVal: Int = scala.io.StdIn.readInt
        
      val l: ListBuffer[Int] = ListBuffer()
      var bo: Boolean = false
        
      for(i <- minVal to maxVal){
        val b: String = BigInt(i.toString).pow(2).toString   

        val s: Int = b.size
        val sum: Int = 
          if(b.size > 1)
            b.take(s/2).toInt + b.drop(s/2).toInt
          else
            b.toInt          

        if(sum == i){
          bo = true
          l append i  
        }
      }
      
      println(if(bo) l.mkString(" ") else "INVALID RANGE")
    }
}
