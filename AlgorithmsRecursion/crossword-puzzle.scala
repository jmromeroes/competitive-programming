trait Direction
object Right extends Direction
object Left extends Direction
object Up extends Direction
object Down extends Direction

object Solution extends App{
  val a: Array[Array[Char]] = Array.ofDim(10, 10)
  
  for(i <- 0 until 10){
    a(i) = scala.io.StdIn.readLine.toArray  
  }
  val words: Array[String] = scala.io.StdIn.readLine.split(";").toArray
  def findLengthOfSpace(a: Array[Array[Char]], from: (Int, Int), direction: Direction): Int = {
    direction match {
      case Right =>
        var x: Int = from._1
        val y: Int = from._2
        var r: Int = 0
        while(x < 10 && a(y)(x) != '+'){
          r += 1
          x += 1
        }
        r
      case Down =>
        val x: Int = from._1
        var y: Int = from._2
        var r: Int = 0
        while(y < 10 && a(y)(x) != '+'){
          r += 1
          y += 1
        }
        r
    }
  }

  def findOriginSpace(a: Array[Array[Char]], from: (Int, Int), direction: Direction): (Int, Int) = {
    var x: Int = from._1
    var y: Int = from._2

    direction match {
      case Left =>
        while(x >= 0 && a(y)(x) != '+'){
          x -= 1
        }
        (x + 1, y)
      case Up =>
        while(y >= 0 && a(y)(x) != '+'){
          y -= 1
        }
        (x, y + 1)
    }
  }

  def fillSpaceWithWord(a: Array[Array[Char]], from: (Int, Int), word: String, direction: Direction): Option[Array[Array[Char]]] = {
    val a2 = a.map(_.clone)
    direction match {
      case Right =>
        for(i <- 0 until word.size){
          val c: Char = a2(from._2)(from._1 + i)
          if( c == word(i) || c == '-')
            a2(from._2)(from._1 + i) = word(i)
          else
            return None
        }
      case Down =>
        for(i <- 0 until word.size){
          val c: Char = a2(from._2 + i)(from._1)
          if( c == word(i) || c == '-')
            a2(from._2 + i)(from._1) = word(i)
          else
            return None
        }
      case _ =>
        return None
    }

    Some(a2)
  }

  def findFreePositionAndDirection(a: Array[Array[Char]]): Option[((Int, Int), Direction)] = {
    for(y <- 0 until 10){
      for(x <- 0 until 10){
        if(a(y)(x) == '-'){
          if(x == 0 && a(y)(x + 1) != '+')
            return (Some((x, y), Right))
          else if(y == 0 && a(y + 1)(x) != '+')
            return (Some((x, y), Down))
          else if(a(y)(x - 1) != '+')
            return Some(findOriginSpace(a, (x, y), Left), Right)
          else if(y > 0 && a(y - 1)(x) != '+')
            return Some(findOriginSpace(a, (x, y), Up), Down)
        }
      }
    }
    None
  }

  def findCrosswordConfiguration(a: Array[Array[Char]], words: Array[String]): (Array[Array[Char]], Boolean) = {
    if(words.isEmpty)
      return (a, true)

    findFreePositionAndDirection(a) match {
      case Some(p) =>
        for(w <- 0 until words.size){
          fillSpaceWithWord(a, p._1, words(w), p._2) match {
            case Some(v) =>
              val f = findCrosswordConfiguration(v, words.take(w) ++ words.drop(w + 1))
              if(f._2){
                return f
              }
            case None =>
              ()
          }
        }
        (Array.ofDim[Char](1,1), false)
      case None =>
        (a, true)
    }
  }

  def printBidimensionalArray(a: Array[Array[Char]]) = {
    for(y <- a){
      for(c <- y){
        print(c)
      }
      println
    }
  }

  printBidimensionalArray(findCrosswordConfiguration(a, words)._1)
}
