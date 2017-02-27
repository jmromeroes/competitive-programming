val sizeList: List[Int] = scala.io.StdIn.readLine.split(" ").map(_.toInt).toList
val size: (Int, Int)    = (sizeList(0), sizeList(1))

case class Point(x: Float, y: Float)

case class Square(p1: Point, p2: Point, p3: Point, p4: Point) {

  val rotationAngle = Math.atan((p2.y-p1.y)/(p2.x - p1.x))
  val midpoint: Point = Point((p1.x + p2.x)/2, (p1.y + p2.y)/2)

  val s: Double = Math.sin(-rotationAngle)
  val c: Double = Math.cos(-rotationAngle)

  def contains(p: Point): Boolean = {

    val _p1: Point = Point((p1.x * c - p1.y * s).toFloat, (p1.y * c + p1.x * s).toFloat)

    var minX = _p1.x
    var maxX = _p1.x
    var minY = _p1.y
    var maxY = _p1.y

    val _p2: Point = Point((p2.x * c - p2.y * s).toFloat, (p2.y * c + p2.x * s).toFloat)
    minX = if(_p2.x < minX) _p2.x else minX
    maxX = if(_p2.x > maxX) _p2.x else maxX
    minY = if(_p2.y < minY) _p2.y else minY
    maxY = if(_p2.y > maxY) _p2.y else maxY

    val _p3: Point = Point((p3.x * c - p3.y * s).toFloat, (p3.y * c + p3.x * s).toFloat)
    minX = if(_p3.x < minX) _p3.x else minX
    maxX = if(_p3.x > maxX) _p3.x else maxX
    minY = if(_p3.y < minY) _p3.y else minY
    maxY = if(_p3.y > maxY) _p3.y else maxY

    val _p4: Point = Point((p4.x * c - p4.y * s).toFloat, (p4.y * c + p4.x * s).toFloat)
    minX = if(_p4.x < minX) _p4.x else minX
    maxX = if(_p4.x > maxX) _p4.x else maxX
    minY = if(_p4.y < minY) _p4.y else minY
    maxY = if(_p4.y > maxY) _p4.y else maxY

    val _p: Point  = Point((p.x * c - p.y * s).toFloat, (p.y * c + p.x * s).toFloat)

    if( _p.x >= minX && _p.y >= minY &&
        _p.x >= minX && _p.y <= maxY &&
        _p.x <= maxX && _p.y <= maxY &&
        _p.x <= maxX && _p.y >= minY ) true
    else false

  }

}

case class Circle(position: Point, radius: Int){

  def contains(p: Point): Boolean = {
    if(Math.sqrt(Math.pow(p.x - position.x, 2) + Math.pow(p.y - position.y, 2)) <= radius)
      true
    else false
  }

}

val circleList: List[Int]  = scala.io.StdIn.readLine.split(" ").map(_.toInt).toList
val circlePosition: Point  = Point(circleList(0), circleList(1))
val circleRadius: Int      = circleList(2)

val squareList: List[Int] = scala.io.StdIn.readLine.split(" ").map(_.toInt).toList
val p1: Point = Point(squareList(0).toFloat, squareList(1).toFloat)
val p3: Point = Point(squareList(2).toFloat, squareList(3).toFloat)

val midpoint: Point = Point((p1.x + p3.x)/2, (p1.y + p3.y)/2)
val midToP1: Point = Point(p1.x - midpoint.x, p1.y - midpoint.y)

val p2: Point = Point(midpoint.x + midToP1.y, midpoint.y - midToP1.x)
val p4: Point = Point(midpoint.x - midToP1.y, midpoint.y + midToP1.x)

val square: Square = Square(p1, p2, p3, p4)
val circle: Circle = Circle(circlePosition, circleRadius)

for ( y  <- 0 until size._2 ) { 
  for( x <- 0 until size._1 ) {
    
    if(square.contains(Point(x,y)) || circle.contains(Point(x,y)))
      print("#")
    else print(".")

  }
  println("")
}
