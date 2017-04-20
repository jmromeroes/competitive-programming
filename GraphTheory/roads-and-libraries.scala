object Solution extends App{
  import scala.collection.mutable.{Map, ListBuffer}

  val sc = new java.util.Scanner (System.in)
  val q: Int = sc.nextInt
  var a0: Int = 0
 
  def getCost(withAccess: Array[Int], m: Map[Int, ListBuffer[Int]], starting: Int, clib: Int, croad: Int, init: Boolean = false): BigInt = {
    if(!withAccess(starting) && init){
      withAccess(starting) = true
      var res: BigInt = BigInt(s"${clib}")
      m get res match {
        case None => ()
        case Some(l) =>
          for(i <- l){
            res += getCost(withAccess, m, i, clib, croad, false)
          }
      }
      res
    } else if(!withAccess(starting)){
      withAccess(starting) = true
      var res: BigInt = BigInt("${croad}")
      m get res match {
        case None => ()
        case Some(l) =>
          for(i <- l){
            res += getCost(withAccess, m, i, clib, croad, false)
          }
      }
      res
    } else {
      0
    }
  }
    
  while(a0 < q){
    val n: Int = sc.nextInt
    val m: Int = sc.nextInt
    val clib: Int = sc.nextInt
    val croad: Int = sc.nextInt
    val withAccess: Array[Boolean](n)
    var res: BigInt = BigInt("0")
    val a1: Int = 0
    val m: Map[Int, ListBuffer[Int]] = Map()
 
    if(croad > clib){
      res = clib * n
    } else {

      while(a1 < m){
        val city_1: Int = sc.nextInt
        val city_2: Int = sc.nextInt
               
        m get city_1 match {
          case None =>
            m += city_1 -> ListBuffer(city_2)
          case Some(l) =>
            l.append(city_2)
        }
        
        a1 += 1
      }

      for(i <- 0 until n){
        if(!withAccess(i))
          res += getCost(withAccess, m, i, clib, croad, true)        
      }
    }

    println(res)

    a0 += 1
  }
  
}
object Solution extends App{
  import scala.collection.mutable.{Map, ListBuffer}

  val sc = new java.util.Scanner (System.in)
  val q: Int = sc.nextInt
  var a0: Int = 0
 
  def getCost(withAccess: Array[Boolean], m: Map[Int, ListBuffer[Int]], starting: Int, clib: Int, croad: Int): BigInt = {
    var res: BigInt = BigInt("0")
    var b: Boolean = true
    
    m get starting match {
      case None => 
        if(withAccess(starting))
          b = false
        else
          withAccess(starting) = true
      case Some(l) =>
        
        for(i <- l){  
          if(!withAccess(i)) {
            withAccess(i) = true
            if(!withAccess(starting)){
              withAccess(starting) = true
            } else {
              b = false
            }
            res += BigInt(s"$croad") + getCost(withAccess, m, i, clib, croad)
          } else {
            if(!withAccess(starting)){
              withAccess(starting) = true
              res += BigInt(s"$croad")
            }
            b = false
          }
          
          
        }
    }
    
    if(b) res + BigInt(s"$clib") else res
  }
    
  while(a0 < q){
    val n: Int = sc.nextInt
    val m: Int = sc.nextInt
    val clib: Int = sc.nextInt
    val croad: Int = sc.nextInt
    val withAccess: Array[Boolean] = new Array[Boolean](n)
    var res: BigInt = BigInt("0")
    var a1: Int = 0
    val map: Map[Int, ListBuffer[Int]] = Map()
    
    while(a1 < m){
      val city_1: Int = sc.nextInt - 1
      val city_2: Int = sc.nextInt - 1
          
      map get city_1 match {
        case None =>
          map += city_1 -> ListBuffer(city_2)
        case Some(l) =>
          l.append(city_2)
      }
        
      a1 += 1
    }
      
    if(croad > clib) {
      res = clib * n
    } else {
      for(i <- 0 until n){
        if(!withAccess(i)){
          res += getCost(withAccess, map, i, clib, croad)
        }
      }
    }

    println(res)

    a0 += 1
  }
  
}
