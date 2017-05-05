object Solution extends App {
  val sc = new java.util.Scanner(System.in)
    
  val n: Int = sc.nextInt
  val d: Int = sc.nextInt
  val a: Array[Int] = new Array[Int](n)
  var currentIndex: Int = 0
  
  for(i <- 0 until n){
    a(i) = sc.nextInt
  }
  
  for(_ <- 0 until d){
    if(currentIndex == n - 1)
      currentIndex = 0
    else
      currentIndex += 1
  }
  
  for(_ <- 0 until n){
    print(a(currentIndex)+ " ")
    if(currentIndex == n - 1)
      currentIndex = 0
    else
      currentIndex += 1
  }
}
