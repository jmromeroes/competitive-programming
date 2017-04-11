object Solution {

    def main(args: Array[String]) {
        import scala.collection.mutable.Map
          
        val sc = new java.util.Scanner (System.in)
        val n1: Int = sc.nextInt
        val n2: Int = sc.nextInt
        val n3: Int = sc.nextInt
          
        val m: Map[Int, Int] = Map()
        
        val h1: Array[Int] = new Array[Int](n1)
        for(h1_i <- 0 until n1) {
          h1(n1 - 1 - h1_i) = sc.nextInt
        }
        
        m(h1(0)) = 1
        for(i <- 1 until n1){
          h1(i) = h1(i) + h1(i - 1)
          m += (h1(i) -> 1)
        }
      
        val h2: Array[Int] = new Array[Int](n2)
        for(h2_i <- 0 until n2) {
          h2(n2 - 1 - h2_i) = sc.nextInt
        }

        m get h2(0) match {
          case Some(v) =>
            m(h2(0)) = v + 1
          case _ => ()
        }
      
        for(i <- 1 until n2){
          h2(i) = h2(i) + h2(i - 1)
          m get h2(i) match {
            case None =>
              ()
            case Some(v) =>
              m(h2(i)) = v + 1
          }
        }
        
        val h3: Array[Int] = new Array[Int](n3)
        for(h3_i <- 0 until n3) {
          h3(n3 - 1 - h3_i) = sc.nextInt  
        }        
        
        m get h3(0) match {
          case Some(v) =>
            m(h3(0)) = v + 1
          case None => ()
        }
      
        for(i <- 1 until n3){
          h3(i) = h3(i) + h3(i - 1)
          m get h3(i) match {
            case None => ()
            case Some(v) =>
              m(h3(i)) = v + 1
          }
        }
        
        var max: Int = 0
        for(k <- m.keys){
          val g: Int = m.get(k).get
          if(g == 3 && k > max)
            max = k
        }
      
        println(max)
      
    }
}
