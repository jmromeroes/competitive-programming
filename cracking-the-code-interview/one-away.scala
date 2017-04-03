import scala.collection.mutable.Map

val m1: Map[Char, Int] = Map()

val s1: String = scala.io.StdIn.readLine
val s2: String = scala.io.StdIn.readLine

for (c <- s1){
  m1 get c match {
    case None =>
      m1 += c -> 1
    case Some(v) =>
      m1(c) = v + 1
  }
}

for (c <- s2){
  m1 get c match {
    case None =>
      m1 += c -> -1
    case Some(v) =>
      m1(c) += -1
  }
}

val sum: Int = m1.values.foldLeft(0)((x, y) => if(y != 0) x + 1 else x)
println(if(sum == 1) "Is modification" else "Is not modification")
