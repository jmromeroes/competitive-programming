import java.util.Scanner
import scala.collection.mutable.{ HashSet, ListBuffer}

object Solution extends App {

  val sc: Scanner = new Scanner(System.in)
  val possibleMappings: ListBuffer[HashSet[Int]] = ListBuffer()
  
  //Number of nodes
  val nn: Int = sc.nextInt
  //Subset references 
  val sr: Array[Int] = Array.fill[Int](nn)(-1)

  //Number of transitions
  val nt: Int = sc.nextInt

  //Number of integers
  val ni: Int = sc.nextInt
  //Input reference
  val input: Array[Int] = new Array[Int](ni)

  val dp: Array[Array[Int]] = Array.ofDim[Int](ni, ni)

  for(i <- 0 until nt){
    val a: Int = sc.nextInt - 1
    val b: Int = sc.nextInt - 1
    
//    println(a, b)
    if(sr(a) != -1 && sr(b) != -1){
//      println("1: ", sr(b), sr(a))
      for(cc <- possibleMappings(sr(b))){
        sr(cc) = sr(a)
        possibleMappings(sr(a)) += cc        
      }
      
    } else if(sr(a) != -1 && sr(b) == -1){
//      println("2: ", sr(b), sr(a))
      sr(b) = sr(a)
      possibleMappings(sr(a)) += b
    } else if(sr(a) == -1 && sr(b) != -1){
      sr(a) = sr(b)
//      println("3: ", sr(b), sr(a))
      possibleMappings(sr(b)) += a      
    } else {
//      println("4: ", sr(b), sr(a))
      //Length of list
      val ll: Int = possibleMappings.size 
      sr(a) = ll
      sr(b) = ll
      possibleMappings.append(HashSet(a, b))
      
    }

  }
  
  for(i <- 0 until ni){
    input(i) = sc.nextInt
    dp(i)(i) = 1
  }

  for(len <- 2 to ni) {
    for(i <- 0 to ni - len) {
      val j: Int = i + len - 1
      if(sr(input(i) - 1) == sr(input(j) - 1) && (sr(input(i) - 1) != -1 || ((input(i) - 1) == (input(j) - 1)))){
        if(len == 2)
          dp(i)(j) = 2
        else
          dp(i)(j) = 2 + dp(i + 1)(j - 1)
      } else {
        dp(i)(j) = Math.max(dp(i + 1)(j), dp(i)(j - 1))
      }
    }
  }

  println(dp(0)(ni - 1))
}
