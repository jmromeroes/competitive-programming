def rotLeft(a: Array[Int], d: Int): Array[Int] = {
   var res = Array.ofDim[Int](a.length)
   var rotationIndex = d % a.length

   for(i <- 0 until a.length){
          if(rotationIndex + i < a.length){
              res(i) = a(rotationIndex + i)
          } else {
              res(i) = a((rotationIndex + i) % a.length)
          }
      }
  
    res
}
