object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
      import scala.collection.mutable.{ Map, ListBuffer }  
       
      val sc = new java.util.Scanner(System.in)
      val n: Int = sc.nextInt
      val arr: Array[Int] = new Array[Int](n)
      val arrB: Array[Boolean] = new Array[Boolean](n)
      val mOri: Map[Int, ListBuffer[Int]] = Map
      val mDes: Map[Int, ListBuffer[Int]] = Map
      var t: Int = 0
        
      for(i <- 0 until n){
        arr(i) = 
      }
        
      for(_ <- 0 until n - 1){
        val v1: Int = sc.nextInt
        val v2: Int = sc.nextInt
        
        mOri get v1 match {
          case None =>
            mOri += v1 -> ListBuffer(v2)
          case Some(l) =>
            l.append(v2)
        }
        
        mDes get v2 match {
          case None =>
            mDes += v2 -> ListBuffer(v1)
          case Some(l) =>
            l.append(v1)
        }
        
      }
      
      for(i <- 0 until n)
    }
}
