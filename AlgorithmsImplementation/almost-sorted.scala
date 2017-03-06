val sc = new java.util.Scanner(System.in)
val n: Int = sc.nextInt

val arr: Array[Int] = new Array[Int](n)

for ( i <- 0 until n) {
  arr(i) = sc.nextInt
}

def checkSortWithSwap(a: Array[Int], n: Int): (Boolean, String) = {
  var indexUntilSorted: Int   = 0
  var indexUntilUnsorted: Int = 0
  var swaped: Boolean = false
  
  for(i -> 0 until (n - 1)) {
    if(a(i) > a(i + 1)){

      swaped match {
        case true =>
          return (false, "") 
        case false =>
          val x: Int = a(i)
          a(i) = a(i + 1)
          a(i + 1) = x
          swaped = true
      }
              
    }
  }
  
}

