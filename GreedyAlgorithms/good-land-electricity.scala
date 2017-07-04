import java.util.Scanner
object Solution extends App {
  val sc: Scanner = new Scanner(System.in)
  val n: Int = sc.nextInt
  val k: Int = sc.nextInt
  val a: Array[Int] = Array.fill[Int](n)(1)

  def getCountOfTowers(): Int = {
    var prev: Int = 0
    var c: Int = 0
    while(prev + k <= n){
      var i: Int = prev
      var prevAux: Int = prev
      var b: Boolean = false
      while(i < prev + k){
        if(a(i) == 1){
          b = true
          prevAux = i
        }
        i += 1
      }
      
      if(b){
        prev = prevAux + k
        c += 1
      } else {
        return -1
      }
    }
    
    c
  }
  
  println(getCountOfTowers())
}
