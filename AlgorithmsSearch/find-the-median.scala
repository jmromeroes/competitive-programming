object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
      val sc = new java.util.Scanner(System.in)
      val n: Int = sc.nextInt
      val a: Array[Int] = new Array[Int](n)
      
      for(i <- 0 until n){
        a(i) = sc.nextInt
      }
      
      def swap(x1: Int, x2: Int) = {
        val aux: Int = a(x1)
        a(x1) = a(x2)
        a(x2) = aux
      }
      
      def partition(left: Int, right: Int, pivot: Int): Int = {
        var storeIndex: Int = left
        val pivotValue: Int = a(pivot)
        swap(right, pivot)
        
        for(i <- left until right){
          if(a(i) < pivotValue){
            swap(storeIndex, i)
            storeIndex += 1
          }
        }        
        swap(storeIndex, right)
        
        storeIndex
      }
      
      def select(index: Int): Int = {
        var right: Int = n - 1
        var left: Int  = 0
        while(true){
          if(left == right)
            return left
        
          val pivot: Int = (right + left)/2
          val pivotIndex: Int = partition(left, right, pivot)
           
          if(pivotIndex == index) {
            return a(index)
          } else if(pivotIndex < index)
            left = pivotIndex + 1
          else
            right = pivotIndex - 1
        }
        0
      }
      
      if(n % 2 == 0)
        println((select(n / 2) + (select(n/2 + 1)) / 2))
      else
        println(select(n/2))
    }
}
object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
      val sc = new java.util.Scanner(System.in)
      val n: Int = sc.nextInt
      val a: Array[Int] = new Array[Int](n)
      
      for(i <- 0 until n){
        a(i) = sc.nextInt
      }
      
      def swap(x1: Int, x2: Int) = {
        val aux: Int = a(x1)
        a(x1) = a(x2)
        a(x2) = aux
      }
      
      def partition(left: Int, right: Int, pivot: Int): Int = {
        var storeIndex: Int = left
        val pivotValue: Int = a(pivot)
        swap(right, pivot)
        
        for(i <- left until right){
          if(a(i) <= pivotValue){
            swap(storeIndex, i)
            storeIndex += 1
          }
        }        
        swap(storeIndex, right)
        
        storeIndex
      }
      
      def select(index: Int): Int = {
        var right: Int = n - 1
        var left: Int  = 0
        var b: Boolean = true 
        var res: Int = 2
        while(true){
          if(left == right)
            return left
        
          val pivot: Int = (right + left)/2
          val pivotIndex: Int = partition(left, right, pivot)
           
          if(pivotIndex == index) {
            return a(index)
          } else if(pivotIndex < index)
            left = pivotIndex + 1
          else
            right = pivotIndex - 1
        }
        0
      }
      
      println(select(n / 2))
    }
}
