object Solution extends App{
  import scala.collection.mutable.{Map, ListBuffer}

  val sc = new java.util.Scanner (System.in)
  val q: Int = sc.nextInt
  var a0: Int = 0
 
  def getCost(withAccess: Array[Boolean], mor: Map[Int, ListBuffer[Int]], mdes: Map[Int, ListBuffer[Int]], starting: Int, clib: Int, croad: Int, init: Boolean = false): BigInt = {
    if(!withAccess(starting) && init){
      withAccess(starting) = true
      var res: BigInt = BigInt(s"$clib")
      mor get starting match {
        case None => ()
        case Some(l) =>
          for(i <- l){
            if(!withAccess(i))
              res += getCost(withAccess, mor, mdes, i, clib, croad)
          }
      }

      mdes get starting match {
        case None => ()
        case Some(l) =>
          for(i <- l){
            if(!withAccess(i))
              res += getCost(withAccess, mor, mdes, i, clib, croad)
          }
      }

      res
    } else if(!withAccess(starting)){
      withAccess(starting) = true
      var res: BigInt = BigInt(s"$croad")
      
      mor get starting match {
        case None => ()
        case Some(l) =>
          for(i <- l){
            if(!withAccess(i))
              res += getCost(withAccess, mor, mdes, i, clib, croad)
          }
      }

      mdes get starting match {
        case None => ()
        case Some(l) =>
          for(i <- l){
            if(!withAccess(i))
              res += getCost(withAccess, mor, mdes, i, clib, croad)
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
    val withAccess: Array[Boolean] = new Array[Boolean](n)
    var res: BigInt = BigInt("0")
    var a1: Int = 0
    val mapOri: Map[Int, ListBuffer[Int]] = Map()
    val mapDes: Map[Int, ListBuffer[Int]] = Map()

    while(a1 < m){
      val city_1: Int = sc.nextInt - 1
      val city_2: Int = sc.nextInt - 1
          
      mapOri get city_1 match {
        case None =>
          mapOri += city_1 -> ListBuffer(city_2)
        case Some(l) =>
          l.append(city_2)
      }

      mapDes get city_1 match {
        case None =>
          mapDes += city_2 -> ListBuffer(city_1)
        case Some(l) =>
          l.append(city_1)
      }

      a1 += 1
    }
      
    if(croad > clib) {
      res = BigInt(s"$clib") * BigInt(s"$n")

    } else {
      for(i <- 0 until n){
        if(!withAccess(i)){
          res += getCost(withAccess, mapOri, mapDes, i, clib, croad, true)
        }
      }
    }
    
    println(res)

    a0 += 1
  }
  
}
