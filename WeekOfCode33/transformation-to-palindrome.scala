import java.util.Scanner
import scala.collection.mutable.{ HashSet, ListBuffer}

object Solution extends App {

  val sc: Scanner = new Scanner(System.in)
  val possibleMappings: ListBuffer[HashSet[Int]] = ListBuffer()
  
  //Number of nodes
  val nn: Int = sc.nextInt
  //Subset references 
  val sr: Array[Int] = Array[nn]() 

  //Number of transitions
  val nt: Int = sc.nextInt

  //Number of integers
  val ni: Int = sc.nextInt
  //Input reference
  val input: Array[Int] = new Array[Int](ni)

  for(i <- 0 until nt){

    val a: Int = sc.nextInt
    val b: Int = sc.nextInt
    
    if(sr(a) != 0 && sr(b) != 0){
      sr(b) = sr(a)

      for(cc <- possibleMappings(sr(b) - 1)){
        sr(cc) = sr(a)
        possibleMappings(sr(a) - 1) += cc        
      }

    } else if(sr(a) != 0 && sr(b) == 0){
      sr(b) = sr(a)
      possibleMappings(sr(a) - 1) += b
    } else if(sr(a) == 0 && sr(b) != 0){
      sr(a) = sr(b)
      possibleMappings(sr(b) - 1) += a      
    } else {
      //Length of list
      val ll: Int = possibleMappings.size 
      sr(a) = ll
      sr(b) = ll
      possibleMappings.append(HashSet(a, b))
    }

  }

  for(i <- 0 until ni){
    input(i) = sc.nextInt
  }

  def getMaxPalindromeLength(s: Int, f: Int): Int{
    val h: Int = sr(input(s))
    val j: Int = sr(input(f))
    if(f - s == 0) 1
    else if(f - s == 1){
      if(h == j) 1
      else 2
    } else if(h == j){
      2 + getMaxPalindromeLength(s + 1, f - 1)
    } else {
      Math.max(getMaxPalindromeLength(s, f - 1), getMaxPalindromeLength(s + 1, f))
    }
  }

  println(getMaxPalindromeLength(0, ni - 1))

}
