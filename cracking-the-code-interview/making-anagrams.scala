object Solution extends App {

  val s1: String = scala.io.StdIn.readLine
  val s2: String = scala.io.StdIn.readLine
  val arr: Array[Int] = new Array[Int](26)

  for{c <- s1}{
    arr(c - 'a') += 1
  }

  for{c <- s2}{
    arr(c - 'a') -= 1
  }
  val res: Int = arr.foldLeft(0)((x, y) => Math.abs(x) + Math.abs(y))
  print(res)
}
