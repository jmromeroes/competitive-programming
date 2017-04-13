object Solution {

    def main(args: Array[String]) {
        import scala.collection.mutable.Map

        val sc = new java.util.Scanner (System.in)
        val n = sc.nextInt()
        val types = new Array[Int](n)
        val arr: Array[Int] = new Array[Int](5)
               
        for(types_i <- 0 to n-1) {
           val in: Int = sc.nextInt
           arr(in - 1) = arr(in - 1) + 1
        }
        
        var maxVal: Int = Int.MinValue
        var indexMax: Int = Int.MaxValue

        for(i <- 0 until 5){          
          if(arr(i) > maxVal){
            maxVal = arr(i)
            indexMax = i
          }
        }
        
        println(indexMax + 1)        
    }
}

