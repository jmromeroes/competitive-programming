object Solution extends App {
  import scala.util.control.Breaks._

  val sc = new java.util.Scanner(System.in)
  val n: Int = sc.nextInt
  val arr: Array[Int] = new Array[Int](n)
  var res: Int = 0

  for(i <- 0 until n){
    arr(i) = sc.nextInt  
  }
  
  def swap(arr: Array[Int], x: Int, x2: Int) = {
    val aux: Int = arr(x)
    arr(x)  = arr(x2)
    arr(x2) = aux
  }

  breakable {
    for(_ <- 0 until n){
      var r: Int = 0
  
      for(i <- 1 until n){
        if(arr(i - 1) > arr(i)){
          swap(arr, i - 1, i)
          r += 1
          res += 1
        }
      }
  
      if(r == 0)
        break
  
    }
  }

  println(s"Array is sorted in $res swaps.")
  println(s"First Element: ${arr(0)}")
  println(s"Last Element: ${arr(n - 1)}")
  
}
