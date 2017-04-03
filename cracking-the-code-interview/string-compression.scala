val s: String = scala.io.StdIn.readLine

val arr: Array[Int] = new Array[Int](26)

for(c <- s){
  arr(c - 'a') = arr(c - 'a') + 1
}

for(i <- 0 until 26){
  if(arr(i) != 0)
    print(s"${(i + 'a').asInstanceOf[Char]}"+arr(i))
}

