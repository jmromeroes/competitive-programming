object Solution extends App {
  val as: Array[Int] = scala.io.StdIn.readLine.split(" ").map(_.toInt).toArray
  val n: Int = as.size
  val al1: Array[(Int, Boolean)] = Array.fill[(Int, Boolean)](n)((0,false))
  val al2: Array[(Int, Boolean)] = Array.fill[(Int, Boolean)](n)((0, true))

  al1(0) = (1, true)
  al2(0) = (1, false)

  def max(s1: (Int, Boolean), s2: (Int, Boolean)): (Int, Boolean) = if (s1._1 > s2._1) s1 else s2
  for(i <- 1 until n){
    var max_prev1: Int = 1
    var max_prev2: Int = 1

    for(j <- 0 until i){
      if(al1(j)._2 == true && as(j) > as(i)){
        if(al1(j)._1 + 1 > max_prev1){
          max_prev1 = al1(j)._1 + 1
          al1(i) = (max_prev1, false)
        }
      } else if (al1(j)._2 == false && as(j) < as(i)){
        if(al1(j)._1 + 1 > max_prev1){
          max_prev1 = al1(j)._1 + 1
          al1(i) = (max_prev1, true)
        }
      }

      if(al2(j)._2 == true && as(j) > as(i)){
        if(al2(j)._1 + 1 > max_prev2){
          max_prev2 = al2(j)._1 + 1
          al2(i) = (max_prev2, false)
        }
      } else if (al2(j)._2 == false && as(j) < as(i)){
        if(al2(j)._1 + 1 > max_prev2){
          max_prev2 = al2(j)._1 + 1
          al2(i) = (max_prev2, true)
        }
      }

    }
  }

  println(Math.max(al1.reduceLeft(max)._1, al2.reduceLeft(max)._1))
}
