object Solution extends App {

  while(true){
    val s: String = scala.io.StdIn.readLine
    val arrLower: Array[Int] = new Array[Int](26)
    val arrUpper: Array[Int] = new Array[Int](26)

    for(i <- s){
      if(i.isLower){
        arrLower(i - 'a') = arrLower(i - 'a') + 1
      } else {
        arrUpper(i - 'A') = arrUpper(i - 'A') + 1
      }
    }

    if(arrLower.filter(_ > 1).size > 0 || arrUpper.filter(_ > 1).size > 0){
      println("YES, repeated letters")
    } else {
      println("NO, unique letters")
    }

  }
}
