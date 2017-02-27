val n: Int = scala.io.StdIn.readInt
        
for(y <- 0 until n){
  for(x <- 0 until n){
    if(n - 1 - y <= x)
        print("#")
    else print(" ")
  }
  println("")
}
